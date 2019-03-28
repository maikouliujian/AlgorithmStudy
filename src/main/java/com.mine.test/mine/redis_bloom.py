import hashlib
from struct import unpack, pack, calcsize
import math
import redis
import random

class BloomFilter:
    """布隆过滤器
       hash function 见第三方库 pybloom_live
       需要安装库
    """

    def __init__(self, redis_db, redis_key, capacity, error_rate=0.00001) -> None:
        self.__redis_db = redis_db
        self.__capacity = capacity
        self.__error_rate = error_rate
        # self.___redis_key = 'BloomFilterKey111'
        self.___redis_key = redis_key

        if not (0 < error_rate < 1):
            raise ValueError("Error_Rate must be between 0 and 1.")
        if not capacity > 0:
            raise ValueError("Capacity must be > 0")
        # given M = num_bits, k = num_slices, P = error_rate, n = capacity
        #       k = log2(1/P)
        #
        # solving for m = bits_per_slice
        # n ~= M * ((ln(2) ** 2) / abs(ln(P)))
        # n ~= (k * m) * ((ln(2) ** 2) / abs(ln(P)))
        # m ~= n * abs(ln(P)) / (k * (ln(2) ** 2))
        self.__num_slices = int(math.ceil(math.log(1.0 / self.__error_rate, 2)))

        self.__bits_per_slice = int(math.ceil(
            (self.__capacity * abs(math.log(self.__error_rate))) /
            (self.__num_slices * (math.log(2) ** 2))))

        print("need hash function count--->" + str(self.__num_slices))
        print("each hash bit count--->" + str(self.__bits_per_slice))
        print("all bit count--->" + str(self.__num_slices * self.__bits_per_slice))
        mem = self.__num_slices * math.ceil(self.__bits_per_slice / 8 / 1024 / 1024)
        print("memory--->" + str(mem) + "M")
        print('-------------------')
        self.___hash_maker, self.__hashfn = self.__make_hashfuncs()

    def __make_hashfuncs(self):
        if self.__bits_per_slice >= (1 << 31):
            fmt_code, chunk_size = 'Q', 8
        elif self.__bits_per_slice >= (1 << 15):
            fmt_code, chunk_size = 'I', 4
        else:
            fmt_code, chunk_size = 'H', 2
        total_hash_bits = 8 * self.__num_slices * chunk_size
        if total_hash_bits > 384:
            hashfn = hashlib.sha512
        elif total_hash_bits > 256:
            hashfn = hashlib.sha384
        elif total_hash_bits > 160:
            hashfn = hashlib.sha256
        elif total_hash_bits > 128:
            hashfn = hashlib.sha1
        else:
            hashfn = hashlib.md5

        fmt = fmt_code * (hashfn().digest_size // chunk_size)
        num_salts, extra = divmod(self.__num_slices, len(fmt))
        if extra:
            num_salts += 1
        salts = tuple(hashfn(hashfn(pack('I', i)).digest()) for i in range(0, num_salts))

        def _hash_maker(key):
            if isinstance(key, str):
                key = key.encode('utf-8')
            else:
                key = str(key).encode('utf-8')
            i = 0
            for salt in salts:
                h = salt.copy()
                h.update(key)
                for uint in unpack(fmt, h.digest()):

                    yield uint % self.__bits_per_slice
                    i += 1
                    if i >= self.__num_slices:
                        return

        return _hash_maker, hashfn


    def add(self, key):
        """ Adds a key to this bloom filter. If the key already exists in this
        filter it will return True. Otherwise False.
        """
        hashes = self.___hash_maker(key)
        # b = _hash_maker('00B80B6C-D611-4298-9619-5DFB93B591a7')
        found_all_bits = True
        offset = 0
        for k in hashes:
            if found_all_bits and 0 == self.__redis_db.getbit(self.___redis_key, offset + k):
                found_all_bits = False
            self.__redis_db.setbit(self.___redis_key, offset + k, 1)
            offset += self.__bits_per_slice
        if not found_all_bits:
            return False
        else:
            return True

    def __contains__(self, key):
        """Tests a key's membership in this bloom filter.
        """
        bits_per_slice = self.__bits_per_slice
        hashes = self.___hash_maker(key)
        offset = 0
        for k in hashes:
            if 0 == self.__redis_db.getbit(self.___redis_key, offset + k):
                return False
            offset += bits_per_slice
        return True

    def memberCount(self) -> int:
        count = self.__redis_db.bitcount(self.___redis_key)
        return count



if __name__ == '__main__':
    pool = redis.ConnectionPool(host='192.168.1.193', port=6379)
    handle = redis.StrictRedis(connection_pool=pool, charset='utf-8')
    bf = BloomFilter(handle, 'test3', 100000000)
    # print(random.randint(0, 100000000))
    count = 0
    # for i in range(0, 10000):
    #     bf.add("0a5217e14645fb816d1a6b43540c43b1" + str(i))
    #     count = count + 1
    # re = bf.add('0a5217e14645fb816d1a6b43540c43b1')
    # print(re)
    # re = bf.add('0a5217e14645fb816d1a6b43540c43b2')
    # print(re)
    # re = bf.add('0a5217e14645fb816d1a6b43540c43b3')
    # print(re)
    # re = bf.add('0a5217e14645fb816d1a6b43540c43b4')
    # print(re)
    # re = bf.add('0a5217e14645fb816d1a6b43540c43b5')
    # print(re)

    print(bf.memberCount())
    print('in----->' + str(count))

    notinCount = 0
    for i in range(0, 10000):
        if "0a5217e14645fb816d0a6b43540c43b1" + str(i) in bf:
            notinCount = notinCount + 1
    print('two in ------->' + str(notinCount))
package main

import (
	"fmt"
	"sync"
)

var a string
var once sync.Once
func setup() {
	a = "hello, world"
}
func doprint() {
	once.Do(setup)
	print(a)
}
func twoprint() {
	go doprint()
	go doprint()
}

func main() {
	//go run("aaaaa")
	//println("Aaa")
	//
	//
	//
	//const af  = 111
	//
	//var a Integer = 1
	//var b Integer = 1
	//a.Add(b)
	//fmt.Print(a)

	//for i := 0; i < 10; i++ {
	//	go Add(i, i)
	//}
	//chs := make([]chan int, 10)
	//for i := 0; i < 10; i++ {
	//	chs[i] = make(chan int)
	//	go Count(chs[i])
	//}
	//for _, ch := range(chs) {
	//	bb := <-ch
	//	fmt.Println(bb)
	//	fmt.Println("over--")
	//}


	x := 10
	var p *int = &x //获取x的地址，然后保存到指针类型的变量p中
	*p += 20        //通过指针类型来操作变量x

	fmt.Println(p, *p)


}

func run(arg string)  {
	print(arg)

}

type Integer int

func (a *Integer) Add(b Integer) {
	*a += b
}

func Add(x, y int) {
	z := x + y
	fmt.Println(z)
}


func Count(ch chan int) {
	//ch <- 1
	fmt.Println("Counting")
}




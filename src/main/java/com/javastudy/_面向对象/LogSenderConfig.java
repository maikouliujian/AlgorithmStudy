package com.javastudy._面向对象;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author : 刘剑
 * @date : 2020/11/4 4:38 下午
 * @description 日志发送配置
 */
@AllArgsConstructor
@Accessors(chain = true)
@Builder
@Data
public class LogSenderConfig implements Serializable {
    private boolean ignoredSend;
    private boolean isSkipTopology;
    private String reporterName;
}

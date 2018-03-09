package org.jz.util;

import org.jz.common.constant.Constants;

import java.util.UUID;

/**
 * @author Hongyi Zheng
 * @date 2018/2/24
 */
public class RandomUtil {

    /**sample number-pool for random pick*/
    private static final String BASE_NUMBER = Constants.BASE_NUMBER;

    /**sample char-pool for random pick*/
    private static final String BASE_CHAR = Constants.BASE_CHAR;

    /**
     * generate an UUID and strip the '-'
     * @return an random uuid
     */
    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-","");
    }


    /**
     * randomly generate a traceId
     * @return
     */
    public static String getTraceId() {
        return getUUID();
    }
}

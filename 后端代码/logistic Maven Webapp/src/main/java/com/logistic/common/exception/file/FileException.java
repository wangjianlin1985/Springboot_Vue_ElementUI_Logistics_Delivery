package com.logistic.common.exception.file;

import com.logistic.common.exception.BaseException;

/**
 * 文件信息异常类
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  姓名 工号
 * @version  [版本号, 2020年4月24日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class FileException extends BaseException
{
    private static final long serialVersionUID = 1L;

    public FileException(String code, Object[] args)
    {
        super("file", code, args, null);
    }

}

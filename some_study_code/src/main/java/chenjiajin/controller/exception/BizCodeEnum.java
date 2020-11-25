package chenjiajin.controller.exception;

public enum  BizCodeEnum {
    UNKNOW_EXCEPTION(10000,"系统未知异常"),
    VAILD_EXCEPTION(10001,"参数格式校验失败");

    private int code;

    private String msg;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    BizCodeEnum(final int code, final String msg) {
        this.code = code;
        this.msg = msg;
    }
}

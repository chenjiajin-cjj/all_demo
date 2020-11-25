package chenjiajin.enums;

public class EnumTest {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            final tt tt = chenjiajin.enums.tt.geTT(i);
            if(null != tt){
                System.out.println(tt.getMsg());
            }
        }
    }
}

enum tt {

    ONE(1, "我"),

    TWO(2, "你"),

    THREE(3, "他");

    public static tt geTT(Integer code) {
        final tt[] values = tt.values();
        for (int i = 0; i < values.length; i++) {
            if (code == values[i].getCode()) {
                return values[i];
            }
        }
        return null;
    }

    private Integer code;
    private String msg;

    tt(final Integer code, final String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(final Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(final String msg) {
        this.msg = msg;
    }

}
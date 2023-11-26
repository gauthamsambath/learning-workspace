package Practising;

/**
 * The type Null check.
 */
public class NullCheck {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        Boolean bool1;
        Boolean bool2;
        RandomRequest randomRequest = new RandomRequest();
        randomRequest.setVal1(Boolean.TRUE);
        randomRequest.setVal2(Boolean.FALSE);
        if (randomRequest.getVal1() || randomRequest.getVal2()) {
            System.out.println("inside if");
        }
    }

}

/**
 * The type Random request.
 */
class RandomRequest {
    /**
     * The Val 1.
     */
    Boolean val1;
    /**
     * The Val 2.
     */
    Boolean val2;

    /**
     * Gets val 1.
     *
     * @return the val 1
     */
    public Boolean getVal1() {
        return val1;
    }

    /**
     * Sets val 1.
     *
     * @param val1 the val 1
     */
    public void setVal1(Boolean val1) {
        this.val1 = val1;
    }

    /**
     * Gets val 2.
     *
     * @return the val 2
     */
    public Boolean getVal2() {
        return val2;
    }

    /**
     * Sets val 2.
     *
     * @param val2 the val 2
     */
    public void setVal2(Boolean val2) {
        this.val2 = val2;
    }
}

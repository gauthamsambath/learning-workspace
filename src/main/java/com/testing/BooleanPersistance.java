package com.testing;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Boolean persistance.
 */
public class BooleanPersistance {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        List<ExceptionRecord> exceptionRecords = createDataSetup();
        if (exceptionRecords.stream().filter(x -> x.getBlockOrderNumber().equals(Long.valueOf(12)))
                .noneMatch(exceptionRecord -> exceptionRecord.getExceptionMessage().equals("FX required"))) {
            System.out.println("Inside if case");
        }


    }

    /**
     * Create data setup list.
     *
     * @return the list
     */
    private static List<ExceptionRecord> createDataSetup() {
        ExceptionRecord exceptionRecord1 = new ExceptionRecord();
        exceptionRecord1.setBlockOrderNumber(14L);
        exceptionRecord1.setExceptionMessage("FX not required");

        ExceptionRecord exceptionRecord2 = new ExceptionRecord();
        exceptionRecord2.setBlockOrderNumber(13L);
        exceptionRecord2.setExceptionMessage("FX not required");

        List<ExceptionRecord> exceptionRecords = new ArrayList<>();
        exceptionRecords.add(exceptionRecord1);
        exceptionRecords.add(exceptionRecord2);

        return exceptionRecords;
    }

    /**
     * Sets bool.
     *
     * @param booleanContainer the boolean container
     */
    public static void setBool(Boolean[] booleanContainer) {
        booleanContainer[0] = true;
    }
}

/**
 * The type Exception record.
 */
class ExceptionRecord {
    /**
     * The Block order number.
     */
    Long blockOrderNumber;
    /**
     * The Exception message.
     */
    String exceptionMessage;

    /**
     * Gets block order number.
     *
     * @return the block order number
     */
    public Long getBlockOrderNumber() {
        return blockOrderNumber;
    }

    /**
     * Sets block order number.
     *
     * @param blockOrderNumber the block order number
     */
    public void setBlockOrderNumber(Long blockOrderNumber) {
        this.blockOrderNumber = blockOrderNumber;
    }

    /**
     * Gets exception message.
     *
     * @return the exception message
     */
    public String getExceptionMessage() {
        return exceptionMessage;
    }

    /**
     * Sets exception message.
     *
     * @param exceptionMessage the exception message
     */
    public void setExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }
}

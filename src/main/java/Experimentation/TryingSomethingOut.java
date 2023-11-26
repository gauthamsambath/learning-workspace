package Experimentation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static java.lang.String.format;

public class TryingSomethingOut {


    public static void main(String[] args) {
        List<String> listOfValidationMessagesOnlyWarning = new ArrayList<>();
        List<String> listOfValidationMessages = new ArrayList<>();
        List<String> repCodeList = Arrays.asList("REP1", "REP2", "REP3");
        String validationWarning1 = "The rep code %s is not part of any advisory practices. hence it cannot be mapped to user";
        String validationError1 = "This is a rep code related error";
        listOfValidationMessagesOnlyWarning.add(validationError1);
        listOfValidationMessagesOnlyWarning.add(format(validationWarning1, repCodeList));
        listOfValidationMessages.add(validationError1);
        listOfValidationMessages.add(format(validationWarning1, repCodeList));
        boolean listsAreEqual = listOfValidationMessages.size() == listOfValidationMessagesOnlyWarning.size() && new HashSet<>(listOfValidationMessages).containsAll(listOfValidationMessagesOnlyWarning);
        System.out.println("Both lists are " + (listsAreEqual ? "equal" : "not equal"));
    }

}

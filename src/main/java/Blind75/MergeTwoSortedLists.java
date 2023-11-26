package Blind75;

public class MergeTwoSortedLists {

    public static void main(String[] args) {

    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode mergedList = null;
        ListNode headNodeMerged = null;
        while(list1!=null && list2!=null){
            if(list1.val < list2.val){
                if (mergedList == null){
                    mergedList = list1;
                    headNodeMerged = mergedList;
                } else {
                    mergedList.next = list1;
                    mergedList = mergedList.next;
                }
                list1 = list1.next;
            } else{
                if (mergedList == null){
                    mergedList = list2;
                    headNodeMerged = mergedList;
                } else {
                    mergedList.next = list2;
                    mergedList = mergedList.next;
                }
                list2 = list2.next;
            }
        }

        if (list1!= null){
            if (mergedList == null){
                mergedList = list1;
                headNodeMerged = mergedList;
            } else {
                mergedList.next = list1;
            }
        }

        if (list2!= null){
            if (mergedList == null){
                mergedList = list2;
                headNodeMerged = mergedList;
            } else {
                mergedList.next = list2;
            }
        }

        return headNodeMerged;
    }
}

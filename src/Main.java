public class Main {
    public static void main(String[] args) {
        int[] array1= new int[]{1,1,1,1,1,1,1,1,1,1,3,5,7};
        int[] array2= new int[]{1,2,3,4,5};
        LinkedIntList deleteFromLinkedIntList = LinkedIntList.fromList(array2);
        LinkedIntList deleteLinkedIntList = LinkedIntList.fromList(array1);
        deleteFromLinkedIntList.removeAll(deleteLinkedIntList);
        deleteFromLinkedIntList.out();
    }
}

class ListIntNode{
    public int data;
    public ListIntNode next;
    ListIntNode(int data){
        this.data=data;
        next=null;
    }
    void add(int val){
        if (this.next == null) {
            this.next = new ListIntNode(val);
        } else {
            this.next.add(val);
        }
    }


}
class LinkedIntList{
    ListIntNode first = null;
    static LinkedIntList fromList(int[] array){
        LinkedIntList list = new LinkedIntList();
        for(int i:array){
            list.add(i);
        }
        return list;
    }
    void add(int val){
        if(first!=null) first.add(val);
        else first = new ListIntNode(val);
    }
    void out() {
        var el = first;
        String result = "";
        while (el != null) {
            result += (el.data)+" ";
            el = el.next;
        }
        System.out.println(result);
    }
    void removeAll( LinkedIntList toDelete) {
        var el = first;
        var toDeleteEl = toDelete.first;
        while (toDeleteEl!=null) {
            while (el!=null&&el.data == toDeleteEl.data&&first==el) {
                el = el.next;
                first = el;
            }
            while (el!=null&&el.next!=null&&el.next.data<toDeleteEl.data) {
                el = el.next;
            }
            while(el!=null && el.next!=null && el.next.data == toDeleteEl.data) {
                el.next = el.next.next;
            }
            toDeleteEl = toDeleteEl.next;
        }
    }
}

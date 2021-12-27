public class Solution13_4_0 {

    public static void main(String[] args) {
        String s = "";

        for(int i = 0; i<1000; i++){
            s += "A";
        }
        System.out.println(s);
    }

}
//Программа будет работать долго, так как переменная типа String - immutable (неизменяемая). И каждая созданная строка будет удалять старую. На это требуется много времени
public class App {
    public static void main(String[] args) throws Exception {
        LinkedList<String> list = new LinkedList<String>();
        list.add("P");
        list.add("A");
        list.add("S");
        list.add("A");
        list.add("A");
        System.out.println(list);
        list.insert("L", 2);
        System.out.println(list);
        list.remove(5);
        System.out.println(list);
        list.swap(4,2);
        System.out.println(list);
        list.remove(2);
        System.out.println(list);
        list.add("A");
        System.out.println(list);
        System.out.println(list.getIndex("S"));
        list.removeByValue("S");
        System.out.println(list);
    }
}

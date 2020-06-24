public class Main {
    public static void main(String arg[]){
        BinarySearchTree b = new BinarySearchTree();
        b.insert(3);b.insert(8);
        b.insert(1);b.insert(4);b.insert(6);b.insert(2);b.insert(10);b.insert(9);
        b.insert(20);b.insert(25);b.insert(15);b.insert(16);
        System.out.println("Original Tree : ");
        b.display(b.root);
        System.out.println();
        b.displayR(b.root, 0);
        System.out.println("");
        System.out.println("\nПоиск элемента со зна4ением 4. Результат:" + b.find(4));
        System.out.println("\nУдаление узла (2)" + b.delete(2));
        b.display(b.root);
        System.out.println("\nУдаление узла (4)" + b.delete(4));
        b.display(b.root);
        System.out.println("\nУдаление узла (10)" + b.delete(10));
        b.display(b.root);
    }
}

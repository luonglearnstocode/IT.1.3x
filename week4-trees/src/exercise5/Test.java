package exercise5;

/*
 * Non-recursive implementation of Binary Trees 
 */
 public class Test {
    public static void main(String args[]) {
        try {
            BTree<String> colorGreen = new NonRecursiveLBTree<String>("color=GREEN");
            BTree<String> colorYellow = new NonRecursiveLBTree<String>("color=YELLOW");
            BTree<String> sizeBig = new NonRecursiveLBTree<String>("size=BIG");
            BTree<String> sizeMedium = new NonRecursiveLBTree<String>("size=MEDIUM");
            BTree<String> sizeSmall = new NonRecursiveLBTree<String>("size=SMALL");
            BTree<String> shapeRound = new NonRecursiveLBTree<String>("shape=ROUND");
            BTree<String> tasteSweet = new NonRecursiveLBTree<String>("taste=SWEET");
            
            BTree<String> watermelon = new NonRecursiveLBTree<String>("watermelon");
            BTree<String> apple = new NonRecursiveLBTree<String>("apple");
            BTree<String> grape = new NonRecursiveLBTree<String>("grape");
            BTree<String> lemon = new NonRecursiveLBTree<String>("lemon");
            BTree<String> banana = new NonRecursiveLBTree<String>("banana");
            BTree<String> cherry = new NonRecursiveLBTree<String>("cherry");
            BTree<String> berry = new NonRecursiveLBTree<String>("berry");
            BTree<String> orange = new NonRecursiveLBTree<String>("orange");

            colorGreen.insert(sizeBig, BTree.LEFT);
            colorGreen.insert(colorYellow, BTree.RIGHT);
        
            sizeBig.insert(watermelon, BTree.LEFT);
            sizeBig.insert(sizeMedium, BTree.RIGHT);
                        
            colorYellow.insert(shapeRound, BTree.LEFT);
            colorYellow.insert(sizeSmall, BTree.RIGHT);
            
            sizeMedium.insert(apple, BTree.LEFT);
            sizeMedium.insert(grape, BTree.RIGHT);
            shapeRound.insert(lemon, BTree.LEFT);
            shapeRound.insert(banana, BTree.RIGHT);
            sizeSmall.insert(tasteSweet, BTree.LEFT);
            sizeSmall.insert(orange, BTree.RIGHT);
            
            tasteSweet.insert(cherry, BTree.LEFT);
            tasteSweet.insert(berry, BTree.RIGHT);

            System.out.println("INORDER: " + colorGreen.toStringInOrder());
            System.out.println("PREORDER: " + colorGreen.toStringPreOrder());
            System.out.println("POSTORDER: " + colorGreen.toStringPostOrder());
            System.out.println(colorGreen.size());
            System.out.println("SIZE=" + colorGreen.size());
            System.out.println("HEIGHT=" + colorGreen.height());
            
        } catch(Exception e) {
            System.out.println("Exception: "+e.getMessage());
        }
    }
}

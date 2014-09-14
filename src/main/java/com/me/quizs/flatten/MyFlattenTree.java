package flatten;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyFlattenTree<T> implements FlattenTree<T> {

	public List<T> flattenInOrder(Tree<T> tree)   {
        if (tree == null)
                throw new IllegalArgumentException("Tree is null.");

            if (tree.get().isLeft()) {

                return Arrays.asList(tree.get().ifLeft( new Function<T, T>() { 

                    public T apply(T p) {
                        return p;
                    }

                } ));

            } else {
                return tree.get().ifRight( new Function<Triple<Tree<T>>, List<T>>() {

                            public List<T> apply(Triple<Tree<T>> p) {

                                List<T> nodes = new ArrayList<T>();
                                nodes.addAll(flattenInOrder(p.left()));
                                nodes.addAll(flattenInOrder(p.middle()));
                                nodes.addAll(flattenInOrder(p.right()));

                                return nodes; //return all fetched nodes
                            }
                    } );

            } //end if

    } //end function


    public static void main(String[] args)
    {
        Tree<Integer> nodes = Tree.Node.tree(5, 4, 9);
        Tree<Integer> root = new Tree.Node<Integer>(Tree.Leaf.leaf(1), nodes, Tree.Leaf.leaf(6));
        MyFlattenTree<Integer> myFlattenTree = new MyFlattenTree<Integer>();

        System.out.println("Flattened tree: " + myFlattenTree.flattenInOrder(root));
    }
}



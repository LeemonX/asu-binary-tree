public class BinarySearchTree {
    public static  Node root;
    public BinarySearchTree(){
        root = null;
    }

    public boolean find(int id){
        Node current = root;
        while(current!=null){
            if(current.data==id){
                return true;
            }else if(current.data>id){
                current = current.left;
            }else{
                current = current.right;
            }
        }
        return false;
    }

    public int findMax(Node current){
        return current.right == null ? current.data : findMax(current.right);
    }

    public int findMin(Node current){
        return current.left == null ? current.data : findMin(current.left);
    }

    public boolean delete(int id){
        Node parent = root;
        Node current = root;
        boolean isLeftChild = false;
        while(current.data!=id){
            parent = current;
            if(current.data>id){
                isLeftChild = true;
                current = current.left;
            }else{
                isLeftChild = false;
                current = current.right;
            }
            if(current ==null){
                return false;
            }
        }

        // Узел без детей
        if(current.left==null && current.right==null){
            if(current==root){
                root = null;
            }
            if(isLeftChild){
                parent.left = null;
            }else{
                parent.right = null;
            }
        }
        // Узел с одним ребенком
        else if(current.right==null){
            if(current==root){
                root = current.left;
            }else if(isLeftChild){
                parent.left = current.left;
            }else{
                parent.right = current.left;
            }
        }
        else if(current.left==null){
            if(current==root){
                root = current.right;
            }else if(isLeftChild){
                parent.left = current.right;
            }else{
                parent.right = current.right;
            }
        }else {


            Node successor	 = getSuccessor(current);
            if(current==root){
                root = successor;
            }else if(isLeftChild){
                parent.left = successor;
            }else{
                parent.right = successor;
            }
            successor.left = current.left;
        }
        return true;
    }

    public Node getSuccessor(Node deleteNode){
        Node successor =null;
        Node successorParent =null;
        Node current = deleteNode.right;
        while(current!=null){
            successorParent = successor;
            successor = current;
            current = current.left;
        }

        if(successor!=deleteNode.right){
            successorParent.left = successor.right;
            successor.right = deleteNode.right;
        }
        return successor;
    }
    public void insert(int id){
        Node newNode = new Node(id);
        if(root==null){
            root = newNode;
            return;
        }
        Node current = root;
        Node parent = null;
        while(true){
            parent = current;
            if(id<current.data){
                current = current.left;
                if(current==null){
                    parent.left = newNode;
                    return;
                }
            }else{
                current = current.right;
                if(current==null){
                    parent.right = newNode;
                    return;
                }
            }
        }
    }

    // Вывод в строку
    public void display(Node root){
        if(root != null){
            display(root.left);
            System.out.print(" " + root.data);
            display(root.right);
        }

    }

    // Кривой недоделанный вывод
    public void displayT(Node root){
        if(root != null){
            displayT(root.left);
            System.out.println(" " + root.data);
            if (root.left != null)
            System.out.print(root.left.data);
            if (root.right != null)
            System.out.print(" " + root.right.data);
            displayT(root.right);
        }
    }

    // Обратный вывод
    public void displayR(Node root, int l) {
        if (root != null){
            displayR(root.right, l+1);
            for (int i=1; i<=l; i++)
                System.out.print("  ");
            System.out.println(root.data);
            displayR(root.left, l+1);
        }
    }
}

class NodeTree {
    ProdPerformance data;
    NodeTree left, right;
    public NodeTree(ProdPerformance item) {
        data = item;
        left = right = null;
    }
}
public class BinarySearchTree{
    static int COUNT = 10;
    NodeTree root;
    BinarySearchTree() {
        root = null;
    }
    static void print2DUtil(NodeTree root, int space)
    {

        if (root == null)
            return;


        space += COUNT;


        print2DUtil(root.right, space);


        System.out.print("\n");
        for (int i = COUNT; i < space; i++)
            System.out.print(" ");
        System.out.print(root.data + "\n");


        print2DUtil(root.left, space);
    }


    static void print2D(NodeTree root)
    {

        print2DUtil(root, 0);
    }
    void insert(ProdPerformance data) {

        root = insertVal(root, data);
    }

    NodeTree insertVal(NodeTree root, ProdPerformance data) {
        if (root == null) {
            root = new NodeTree(data);
            return root;
        }

        if (data.getItemID() < root.data.getItemID())
            root.left = insertVal(root.left, data);

        else if (data.getItemID() > root.data.getItemID())
            root.right = insertVal(root.right, data);
        return root;
    }

    void inorder() {
        inorderVisit(root);
    }

    void inorderVisit(NodeTree root) {
        if (root != null) {
            inorderVisit(root.left);
            System.out.print(root.data + " -> ");
            inorderVisit(root.right);
        }
    }
    void preorderVisit(NodeTree root){
        if (root!=null){
            System.out.println(root.data+" -> ");
            preorderVisit(root.left);
            preorderVisit(root.right);
        }
    }
    void postorderVisit(NodeTree root){
        if (root!=null){
            postorderVisit(root.left);
            postorderVisit(root.right);
            System.out.println(root.data+" -> ");
        }
    }
    int height(NodeTree root){
        if (root == null){
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
        if (left>right){
            return left+1;
        }
        else return right+1;
    }
    void levelOrder(){
        int h = height(root);
        for (int i = 0; i < h; i++) {
            levelOrderVisit(root,i);
        }
        System.out.println();
    }
    void levelOrderVisit(NodeTree root,int level){
        if (root==null){
            return;
        }
        if (level==0){
            System.out.print(root.data+" ");
        }
        else if (level>0){
            levelOrderVisit(root.left,level-1);
            levelOrderVisit(root.right,level-1);
        }
    }

    void delete(ProdPerformance data) {
        root = deleteVal(root, data);
    }
    NodeTree deleteVal(NodeTree root, ProdPerformance data) {

        if (root == null)
            return root;

        if (data.getItemID() < root.data.getItemID())
            root.left = deleteVal(root.left, data);
        else if (data.getItemID() > root.data.getItemID())

            root.right = deleteVal(root.right, data);
        else {

            if (root.left!=null&&root.right!=null){
                root.data = minValue(root.right);
                root.right = deleteVal(root.right, root.data);
            }
            else if (root.left == null){
                return root.right;}
            else {
                return root.left;}
        }
        return root;
    }

    ProdPerformance minValue(NodeTree root) {
        ProdPerformance minV = root.data;
        minV = traverseMin(root,minV);
        return minV;
    }
    ProdPerformance traverseMin(NodeTree root,ProdPerformance min){
        if (root==null){
            return min;
        }
        if (root.data.getActualS()-root.data.getTargetS()<min.getActualS()-min.getTargetS()){
            min = root.data;
        }
        min = traverseMin(root.left,min);
        min = traverseMin(root.right,min);
        return min;
    }
    ProdPerformance SearchValue(NodeTree root,int itemID){
        if (root == null) return null;
        if (root.data.getItemID()==itemID){
            return root.data;
        }
        else if (itemID<root.data.getItemID()) {
            return SearchValue(root.left,itemID);
        } else if (itemID>root.data.getItemID()){
            return SearchValue(root.right,itemID);
        }
        return root.data;
    }
}
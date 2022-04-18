import java.util.*;
public class deletionintree 
{
    static Scanner sc=null;
    public static void main(String args[])
    {
        deletionintree obj=new deletionintree();
        sc=new Scanner(System.in);
        node root=createTree();
        System.out.println("enter the key");
        int key=sc.nextInt();
       deletenode(root, key);
       inorderRec(root);
        
    
    }
    static node createTree()
    {
        node root=null;
        System.out.println("enert the data");
        int data=sc.nextInt();
        if(data==-1)
        {
            return null;
        }
        root=new node(data);
        System.out.println("enter the left value " +data);
        root.left=createTree();
        System.out.println("enter the right valuse "+data);
        root.right=createTree();
        return root;
    }
   static node deletenode(node root,int key)
    {
        if(root==null)
        {
            return root;
        }
        if(key>root.data)
        {
            root.right=deletenode(root.right, key);
        }
        else if(key<root.data)
        {
            root.left=deletenode(root.left, key);
        }
        else
        {
            if(root.left==null)
            {
                return root.right;
            }
            else if(root.right==null)
            {
                return root.left;
            }
            root.data=minvalue(root.right);//this line 
            root.right=deletenode(root.right,root.data);//and this line is very important in feltion loic nhi smjh me a rha hai,...
            
        }
        return root;
    }
static int minvalue( node root)
    {
        int min=root.data;
        while(root.left!=null)
        {
            min=root.left.data;
            root=root.left;
        }
        return min;
    }
   
    static void inorderRec(node root)
    {
        if (root != null) {
            inorderRec(root.left);
            System.out.println(root.data);
            inorderRec(root.right);
        }
    }

}
class node
{
    node left,right;
    int data;
    node(int data)
    {
        this.data=data;
    }
}

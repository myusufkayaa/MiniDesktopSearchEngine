package MiniDesktopSearchEngine;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


/*
 * @file MiniDesktopSearchEngine
 * @description Masaüstü mini bir arama motoru
 * @assignment odev2
 * @date 10.03.2019
 * @author Muhammed Yusuf KAYA myusufka@gmail.com
 */
public class BinarySearchTree<T extends Comparable<T>> {

    private TreeNode<T> root;

    // recursive insert method
    TreeNode<T> insertRecursive(TreeNode<T> node) {
        if (node == null) {
            return new TreeNode<>();
        } else {
            if (node.data.compareTo(node.data) > 0) {
                node.right = insertRecursive(node.right);
            } else if (node.data.compareTo(node.data) < 0) {
                node.left = insertRecursive(node.left);
            }

            return node;
        }
    }

    // iterative insert method
    void insert(TreeNode<T> node) {

        if (root == null) {
            root = node;
        } else {
            TreeNode<T> temp = root;

            while (temp != null) {
                if (node.data.compareTo(temp.data) > 0) {
                    if (temp.right == null) {
                        temp.right = node;
                        return;
                    }

                    temp = temp.right;
                } else if (node.data.compareTo(temp.data) < 0) {
                    if (temp.left == null) {
                        temp.left = node;
                        return;
                    }

                    temp = temp.left;
                } else {
                    return;
                }
            }

        }
    }

    // iterative search method
    boolean search(T searchData) {
        if (root == null) {

        } else {
            TreeNode<T> temp = root;

            while (temp != null) {
                if (searchData.compareTo(temp.data) > 0) {
                    temp = temp.right;
                } else if (searchData.compareTo(temp.data) < 0) {
                    temp = temp.left;
                } else {
                    return true;
                }
            }

        }
        return false;
    }
    TreeNode<T> foundNode(T searchData) {
        if (root == null) {

        } else {
            TreeNode<T> temp = root;

            while (temp != null) {
                if (searchData.compareTo(temp.data) > 0) {
                    temp = temp.right;
                } else if (searchData.compareTo(temp.data) < 0) {
                    temp = temp.left;
                } else {
                    return temp;
                }
            }

        }
        return null;
    }

    void preorder() {
        System.out.print("preorder : ");
        preorder(root);
        System.out.println();
    }

    private void preorder(TreeNode<T> node) {
        if (node != null) {
            System.out.print(node.data);
            node.list.print();
            System.out.println("");
            preorder(node.left);
            preorder(node.right);
        }
    }
    private void sPreorder(TreeNode<T> node,BufferedWriter bw) throws IOException{//Burada ise dosyamıza çıktıyı yazdırıyoruz. Parametre olarak BufferedWriter aldığı için sürekli açmıyoruz.
         String s="";
        if (node != null) {
            s+=(node.data.toString());
            s+=(node.list.sPrint());
            s+="\n";
            bw.write(s);
            
            System.out.println(s);
            
            sPreorder(node.left,bw);
            sPreorder(node.right,bw);
            
        }
        
    }
    void sPreorder(File file) throws IOException{
        BufferedWriter bw=new BufferedWriter(new FileWriter(file,true));
        sPreorder(root, bw);
        bw.close();
       
    }
    

    void inorder() {
        System.out.print("inorder : ");
        inorder(root);
        System.out.println();
    }

    private void inorder(TreeNode<T> node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.data + " ");
            inorder(node.right);
        }
    }

    void postorder() {
        System.out.print("postorder : ");
        postorder(root);
        System.out.println();
    }

    private void postorder(TreeNode<T> node) {
        if (node != null) {
            postorder(node.left);
            postorder(node.right);
            System.out.print(node.data + " ");
        }
    }

    int sumRecursive() {
        return sumRecursive(root);
    }

    // recursive sum method
    private int sumRecursive(TreeNode<T> node) {
        if (node != null) {
            if (node.data instanceof Number) {
                return ((Number) node.data).intValue() + sumRecursive(node.left) + sumRecursive(node.right);
            }
        }

        return 0;
    }

    int sizeRecursive() {
        return sizeRecursive(root);
    }

    // recursive size method
    private int sizeRecursive(TreeNode<T> node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + sizeRecursive(node.left) + sizeRecursive(node.right);
        }
    }

    int fullNodeCountRecursive() {
        return fullNodeCountRecursive(root);
    }

    // recursive full node (node that have both left and right child) count method
    private int fullNodeCountRecursive(TreeNode<T> node) {
        if (node == null) {
            return 0;
        } else {
            if (node.left != null && node.right != null) {
                return 1 + fullNodeCountRecursive(node.left) + fullNodeCountRecursive(node.right);
            } else {
                return 0 + fullNodeCountRecursive(node.left) + fullNodeCountRecursive(node.right);
            }
        }
    }

    LinkedList ignoreList(File file) throws FileNotFoundException, IOException {
        LinkedList<T> ignoreList = new LinkedList<T>();
        BufferedReader bf = new BufferedReader(new FileReader(file));
        String str;
        while ((str = bf.readLine()) != null) {
            ignoreList.addFirst((T) str);
        }
        return ignoreList;
    }

    /*void createTree(File file, File ignoreFile) throws FileNotFoundException, IOException {
        LinkedList<String> ignoreList = ignoreList(ignoreFile);
        for (int i = 0; i < file.listFiles().length; i++) {
            if (file.listFiles()[i].getName().endsWith(".html")) {
                Scanner input = new Scanner(file.listFiles()[i]);
                while (input.hasNext()) {
                    String word = input.next();
                    if (ignoreList.searchData(word) | word.equals(".") | word.equals(",")) {
                        continue;
                    } else {
                        if (search((T) word)) {
                            continue;

                        } else {
                            if (!word.startsWith("<")) {
                                TreeNode<String> newNode = new TreeNode<>(word);
                                int counter;
                                LinkedList<T> fileList = new LinkedList<T>();
                                for (int j = 0; j < file.listFiles().length; j++) {
                                    counter = 0;
                                    Node cNode = new Node();
                                    cNode.data = file.listFiles()[j].getName();
                                    Scanner cInput = new Scanner(file.listFiles()[j]);
                                    while (cInput.hasNext()) {
                                        String cWord = cInput.next();
                                        if (cWord.equals(word)) {
                                            counter++;
                                        }
                                    }
                                    cNode.frequency = counter;
                                    fileList.addFirst(cNode);
                                }
                                newNode.list = fileList;
                                insert((TreeNode<T>) newNode);
                            }
                        }
                    }
                }
            }
        }
    }*/
    void createTree(File file, File ignoreFile) throws IOException{
        LinkedList<String> ignoreList = ignoreList(ignoreFile);//ilk önce ignorelistteki kelimelerden bir linkedlist oluşturuyoruz
        for (int i = 0; i < file.listFiles().length; i++) {//klasördeki dosyaları okumak için dönüyoruz.
            if (file.listFiles()[i].getName().endsWith(".html")) {//dosyanın html olup olmadığını kontrol ediyoruz.
                Scanner input = new Scanner(file.listFiles()[i]);// scanner ile kelimeleri okuyacağız.
                while(input.hasNext()){//dosyanın sonuna kadar dönüyoruz
                    String word = input.next();//okuduğumuz kelimeyi stringe atıyoruz
                    if (ignoreList.searchData(word) | word.equals(".") | word.equals(",")|word.startsWith("<")) {//kelimenin kurallara uyup uymadığını kontrol ediyoruz.
                        continue;
                    }else{
                        if (search((T) word)) {//Bulduğumuz kelimenin treede olup olmadığını kontrol ediyoruz.
                            if (foundNode((T) word).list.searchData(file.listFiles()[i].getName())) {//Linkedlistte dosyanın olup olmadığını kontrol ediyoruz.
                                foundNode((T) word).list.foundNode(file.listFiles()[i].getName()).frequency+=1;// Eğer linkedlistte bulunuyorsa frequency 1 arttırılır. 
                            }else{//Eğer Linkedlistte bulunmuyorsa tanımlayıp ekliyoruz
                                Node<String> newNode=new Node<>();
                                newNode.data=file.listFiles()[i].getName();
                                newNode.frequency=1;
                                foundNode((T) word).list.addFirst(newNode);
                            }
                        }else{//Eğer kelime ağaçta yoksa ağaca ekliyoruz.
                            TreeNode<String> tNode=new TreeNode<>();
                            LinkedList<String> newList=new LinkedList<>();
                            Node<String> newNode=new Node<>();
                            newNode.data=file.listFiles()[i].getName();
                            newNode.frequency=1;
                            newList.addFirst(newNode);
                            tNode.list=newList;
                            tNode.data=word;
                            insert((TreeNode<T>) tNode);
                        }
                    }
                }
            }
        }

        
    }

     void fileWrite(File file, TreeNode<T> node) throws IOException {
       
            
            
        }
        
    
    
}

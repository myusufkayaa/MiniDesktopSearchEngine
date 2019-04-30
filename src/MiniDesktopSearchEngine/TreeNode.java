package MiniDesktopSearchEngine;

/*
 * @file MiniDesktopSearchEngine
 * @description Masaüstü mini bir arama motoru
 * @assignment odev2
 * @date 10.03.2019
 * @author Muhammed Yusuf KAYA myusufka@gmail.com
 */
public class TreeNode<String extends Comparable<String>> {

    String data;
    TreeNode<String> left;
    TreeNode<String> right;
    LinkedList list;

    public TreeNode(String data) {
        this.data = data;
    }

    public TreeNode() {
    }
    

}

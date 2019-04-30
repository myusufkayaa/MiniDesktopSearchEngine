
package MiniDesktopSearchEngine;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/*
 * @file MiniDesktopSearchEngine
 * @description Masaüstü mini bir arama motoru
 * @assignment odev2
 * @date 10.03.2019
 * @author Muhammed Yusuf KAYA myusufka@gmail.com
 */
public class Test {
    public static void main(String[] args) throws IOException {
       BinarySearchTree<String> bst=new BinarySearchTree<>();
       File f=new File("src\\belgeler");
       File ignoreList=new File("src\\belgeler\\ignoreList.txt");
       bst.createTree(f, ignoreList);
       File fw=new File("src\\belgeler\\output.txt");
       bst.sPreorder(fw);
    }
}

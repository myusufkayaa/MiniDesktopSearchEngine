package MiniDesktopSearchEngine;

/*
 * @file MiniDesktopSearchEngine
 * @description Masaüstü mini bir arama motoru
 * @assignment odev2
 * @date 10.03.2019
 * @author Muhammed Yusuf KAYA myusufka@gmail.com
 */
public class Node<String extends Comparable<String>> {

    String data;
    int frequency;
    Node<String> next;

    public Node(String data) {
        this.data = data;
        this.next = null;
    }

    public Node() {
    }

}

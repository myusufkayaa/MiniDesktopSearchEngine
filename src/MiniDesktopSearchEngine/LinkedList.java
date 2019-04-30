package MiniDesktopSearchEngine;

/*
 * @file MiniDesktopSearchEngine
 * @description Masaüstü mini bir arama motoru
 * @assignment odev2
 * @date 10.03.2019
 * @author Muhammed Yusuf KAYA myusufka@gmail.com
 */
public class LinkedList<T extends Comparable<T>> {

    Node<T> head;

    void addFirst(Node newNode) {
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    void addFirst(T data) {
        addFirst(new Node<>(data));
    }

    void addLast(T data) {
        Node<T> newNode = new Node<>(data);

        if (head == null) {
            head = newNode;
        } else {
            Node<T> temp = head;

            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = newNode;
        }
    }

    void insertAfter(T data, T search) {
        Node<T> temp = head;

        while (temp != null && temp.data != search) {
            temp = temp.next;
        }

        if (temp != null) {
            Node<T> newNode = new Node<>(data);
            newNode.next = temp.next;
            temp.next = newNode;
        } else {
            addLast(data);
        }
    }

    boolean remove(T data) {
        if (head == null) {
            System.out.println("empty list !");
        } else {
            if (head.data.equals(data)) {
                head = head.next;
                return true;
            } else {
                Node<T> temp = head.next;
                Node<T> prev = head;

                while (temp != null && !temp.data.equals(data)) {
                    prev = temp;
                    temp = temp.next;
                }

                if (temp != null) {
                    prev.next = temp.next;
                    return true;
                } else {
                    System.out.println(data + " not found !");
                }
            }
        }
        return false;
    }

    void print() {
        Node<T> temp = head;

        while (temp != null) {
            System.out.print("("+temp.data + " - " + temp.frequency+")->");
            temp = temp.next;
        }

        System.out.println("null");
    }
   String sPrint(){
        String s="";
        Node<T> temp = head;
        while (temp != null) {
            s+="("+temp.data + " - " + temp.frequency+")->";
            temp = temp.next;
        }
        return s;
    }

    boolean searchData(T data) {
        if (head.data.equals(data)) {
            return true;
        } else {
            Node<T> temp = head.next;
            while (temp != null && !temp.data.equals(data)) {
                temp=temp.next;
            }
            if (temp != null) {
                return true;
            }
        }

        return false;
    }
    Node<T> foundNode(T data) {
        if (head.data.equals(data)) {
            return head;
        } else {
            Node<T> temp = head.next;
            while (temp != null && !temp.data.equals(data)) {
                temp=temp.next;
            }
            if (temp != null) {
                return temp;
            }
        }

        return null;
    }
    

    int size() {
        Node<T> temp = head;
        int count = 0;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        return count;
    }
}

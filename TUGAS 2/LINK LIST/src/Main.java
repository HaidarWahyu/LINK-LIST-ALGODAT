abstract class Student {
    String name;
    String studentNumber;

    abstract void showMajor();
}

class ComputerScience extends Student {
    void showMajor() {
        System.out.println(name + " (" + studentNumber + ") - Major: Computer Science");
    }
}

class Mathematics extends Student {
    void showMajor() {
        System.out.println(name + " (" + studentNumber + ") - Major: Mathematics");
    }
}

class Engineering extends Student {
    void showMajor() {
        System.out.println(name + " (" + studentNumber + ") - Major: Engineering");
    }
}

// -------------------- Singly Linked List --------------------
class SinglyNode {
    Student data;
    SinglyNode next;

    SinglyNode(Student data) {
        this.data = data;
        this.next = null;
    }
}

class SinglyLinkedList {
    SinglyNode head;

    void insert(Student s) {
        SinglyNode newNode = new SinglyNode(s);
        if (head == null) {
            head = newNode;
            return;
        }
        SinglyNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    void display() {
        SinglyNode temp = head;
        while (temp != null) {
            temp.data.showMajor();
            temp = temp.next;
        }
    }
}

// -------------------- Doubly Linked List --------------------
class DoublyNode {
    Student data;
    DoublyNode next, prev;

    DoublyNode(Student data) {
        this.data = data;
        this.next = this.prev = null;
    }
}

class DoublyLinkedList {
    DoublyNode head;

    void insert(Student s) {
        DoublyNode newNode = new DoublyNode(s);
        if (head == null) {
            head = newNode;
            return;
        }
        DoublyNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.prev = temp;
    }

    void displayForward() {
        DoublyNode temp = head;
        while (temp != null) {
            temp.data.showMajor();
            temp = temp.next;
        }
    }

    void displayBackward() {
        if (head == null) return;
        DoublyNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        while (temp != null) {
            temp.data.showMajor();
            temp = temp.prev;
        }
    }
}

// -------------------- Circular Linked List --------------------
class CircularNode {
    Student data;
    CircularNode next;

    CircularNode(Student data) {
        this.data = data;
        this.next = null;
    }
}

class CircularLinkedList {
    CircularNode head = null, tail = null;

    void insert(Student s) {
        CircularNode newNode = new CircularNode(s);
        if (head == null) {
            head = tail = newNode;
            tail.next = head; // circular link
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
    }

    void display() {
        if (head == null) return;
        CircularNode temp = head;
        do {
            temp.data.showMajor();
            temp = temp.next;
        } while (temp != head);
    }
}

// -------------------- Main --------------------
public class Main {
    public static void main(String[] args) {
        // Create student objects
        ComputerScience s1 = new ComputerScience();
        s1.name = "MAMAT";
        s1.studentNumber = "20250101";

        Mathematics s2 = new Mathematics();
        s2.name = "UCUP";
        s2.studentNumber = "20250102";

        Engineering s3 = new Engineering();
        s3.name = "UPIN";
        s3.studentNumber = "20250103";

        ComputerScience s4 = new ComputerScience();
        s4.name = "SUPARMAN";
        s4.studentNumber = "20250110";

        // Singly Linked List
        System.out.println("=== Singly Linked List ===");
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.insert(s1);
        sll.insert(s2);
        sll.insert(s3);
        sll.insert(s4);
        sll.display();

        // Doubly Linked List
        System.out.println("\n\n=== Doubly Linked List (Forward) ===");
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.insert(s1);
        dll.insert(s2);
        dll.insert(s3);
        dll.insert(s4);
        dll.displayForward();

        System.out.println("\n=== Doubly Linked List (Backward) ===");
        dll.displayBackward();

        // Circular Linked List
        System.out.println("\n\n=== Circular Linked List ===");
        CircularLinkedList cll = new CircularLinkedList();
        cll.insert(s1);
        cll.insert(s2);
        cll.insert(s3);
        cll.insert(s4);
        cll.display();
    }
}

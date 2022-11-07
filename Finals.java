import java.io.*;

public class Finals {
    public int d;
    public Finals next;

    public Finals(int x) {
        d = x;
    }

    public void displayFinals() {
        System.out.print(d + "  ");
    }
}

class LinkList {
    private Finals f;
    private Finals l;

    public LinkList() {
        f = null;
        l = null;
    }

    public void insertLast(int x) {
        Finals newFinals = new Finals(x);
        newFinals.next = null;
        if (isEmpty())
            f = newFinals;
        else
            l.next = newFinals;
        l = newFinals;
    }

    public int delete() {
        int t = f.d;
        if (f.next == null)
            l = null;
        f = f.next;
        return t;
    }

    public int peek() {
        return (f.d);
    }

    public boolean isEmpty() {
        return (f == null);
    }

    public void displayList() {
        Finals current = f;
        while (current != null) {
            current.displayFinals();
            current = current.next;
        }
    }
}

class Queue {
    private LinkList l;

    public Queue() {
        l = new LinkList();
    }

    public void insert(int x) {
        l.insertLast(x);
        System.out.println(" Successful add another one");
    }

    public int delete() {
        return l.delete();
    }

    public boolean isQueueEmpty() {
        return l.isEmpty();
    }

    public void display() {
        l.displayList();
    }

    public int peek() {
        return l.peek();
    }
}

class QueueList {
    public static void main(String args[]) throws IOException {
        Queue q = new Queue();
        int c, d;
        while ((boolean) true) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Waiting List Queue");
            System.out.println("****************");
            System.out.println("1.Insert");
            System.out.println("2.Delete");
            System.out.println("3.Next Number in the list");
            System.out.println("4.Display the Queue List");
            System.out.println("5.Quit");
            System.out.println("Choose a Number ");
            c = Integer.parseInt(br.readLine());
            if (c == 5)
                break;
            else {
                switch (c) {
                    case 1:
                        System.out.println("Enter the size of the queue list ");
                        int n1 = Integer.parseInt(br.readLine());
                        System.out.println("Input a Number: ");
                        for (int i = 0; i < n1; i++) {
                            d = Integer.parseInt(br.readLine());
                            q.insert(d);
                        }

                        break;
                    case 2:
                        if (q.isQueueEmpty())
                            System.out.println(" Empty ");
                        else {
                            d = q.delete();
                            System.out.println("Deleted Number!!:-  " + d);
                        }
                        break;
                    case 3:
                        if (q.isQueueEmpty())
                            System.out.print("Queue is Empty ");
                        else {
                            d = q.peek();
                            System.out.println("Next is: " + d);
                        }
                        break;
                    case 4:
                        if (q.isQueueEmpty())
                            System.out.println("Queue is Empty ");
                        else {
                            System.out.println("Numbers in Line is ");
                            q.display();
                        }
                        break;
                    default:
                        System.out.println("Invalid choice ");
                }
            }
            System.out.println(" ");
        }
    }
}

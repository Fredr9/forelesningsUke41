package forelesningRekursivtBinarySearch;

public class CircularBuffer {
    char[] buffer;
    int size;
    int head; // Peker til startetn av køen
    int tail; // Peker tkl slutten av køen
    int count; // Antall elementer som er i køen nå.

    CircularBuffer(int size) {
        buffer = new char[size];
        this.size = size;
        this.head = 0;
        this.tail = 0;
        this.count = 0;
    }

    void pushBack(char values) {
        if(count+1 > size){
            throw new IllegalArgumentException("Det er for stort antall");
        }
        this.buffer[tail] = values;
        tail = (tail + 1) % size;
        count = count + 1;

    }

    char popFront() {
        if(count <= 0){
            throw new IndexOutOfBoundsException();
        }
        char returnValue = buffer[head];
        System.out.print(head);
        head = (head + 1) % size;
        count = count - 1;
        return returnValue;
    }

    int count() {
        return count;
    }

    public static void main(String[] args) {
        CircularBuffer buffer = new CircularBuffer(7);

        char[] val = "ABCDEFGHIJKLMOPRST".toCharArray();
        for (int i = 0; i < val.length; ) {
            // legger inn tre bokstaver
            for (int j = 0; j < 7; ++j) {
                if (val.length > i + j) {
                    buffer.pushBack(val[i + j]);
                    //i++;
                }
            }

            //Ta ut alt fra bufferet;
            while (buffer.count > 0) {
                System.out.print(buffer.popFront());
            }
            System.out.println();

            i = i + 6;
        }
    }
}

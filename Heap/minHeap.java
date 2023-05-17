package Heap;

public class minHeap {
    
    public int size;
    public int[] Heap;
    public int maxSize;

    public minHeap(int maxSize){
        this.size = 0;
        this.maxSize = maxSize;
        Heap = new int[maxSize+1];
        Heap[0] = Integer.MIN_VALUE;
    }

    public int leftChild(int pos) {
        return 2 * pos;
    }

    public int rightChild(int pos) {
        return 2 * pos + 1;
    }

    public boolean isLeaf(int pos) {
        if (pos <= size && pos > size / 2)
            return true;
        return false;
    }

    public int parent(int pos) {
        return pos / 2;
    }

    public void swap(int fpos, int spos) {
        int temp = Heap[spos];
        Heap[spos] = Heap[fpos];
        Heap[fpos] = temp;
    }

    public void insert(int val) {
        Heap[++size] = val;
        int tx = size;
        int parent = parent(tx);
        while (Heap[parent] > Heap[tx]) {
            swap(parent, tx);
            tx = parent;
            parent = parent(tx);
        }

    }

    public void minHeapify(int pos) {
        if (isLeaf(pos))
            return;
        if (Heap[pos] > Heap[leftChild(pos)] || Heap[pos] > Heap[rightChild(pos)]) {
            if (Heap[leftChild(pos)] > Heap[rightChild(pos)]) {
                swap(pos, leftChild(pos));
                minHeapify(leftChild(pos));
            } else {
                swap(pos, rightChild(pos));
                minHeapify(rightChild(pos));
            }
        }
    }

    public void print() {
        for (int i = 1; i <= size / 2; i++) {
            System.out.print(
                    " PARENT : " + Heap[i] + " LEFT CHILD : " + Heap[2 * i] + " RIGHT CHILD :" + Heap[2 * i + 1]);
            System.out.println();
        }
    }

    public int extractMax() {
        int pop = Heap[1];
        Heap[1] = Heap[size--];
        minHeapify(1);
        return pop;
    }

    public static void main(String[] arg) {
        System.out.println("The Max Heap is ");
        minHeap maxHeap = new minHeap(15);
        maxHeap.insert(5);
        maxHeap.insert(3);
        maxHeap.insert(17);
        maxHeap.insert(10);
        maxHeap.insert(84);
        maxHeap.insert(19);
        maxHeap.insert(6);
        maxHeap.insert(22);
        maxHeap.insert(9);

        maxHeap.print();
        System.out.println("The min val is " + maxHeap.extractMax());
    }
}

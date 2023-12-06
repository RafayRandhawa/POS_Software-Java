public class MaxHeap {
    ProdPerformance [] heap;
    int capacity;
    int size;
    public MaxHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.heap = new ProdPerformance[capacity];
    }
    int parent(int index) {
        return (index-1)/2;
    }
    int leftChild(int index){
        return (2*index)+1;
    }
    int rightChild(int index){
        return (2*index)+2;
    }
    void heapifyUp(int index){
        int temp = index;
        while(temp>0 && (heap[temp].getActualS() - heap[temp].getTargetS()) > (heap[parent(temp)].getActualS() - heap[parent(temp)].getTargetS())){
            swap(heap, temp, parent(temp));
            temp = parent(temp);
        }
    }
    void swap(ProdPerformance[] arr, int a, int b){
        ProdPerformance temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    void insert(ProdPerformance data){
        if(size>=capacity){
            System.out.println("heap is full, cannot insert");
            return;
        }
        heap[size] = data;
        heapifyUp(size);
        size++;

    }
    public ProdPerformance root(){
        return heap[0];
    }
    void deleteRoot(){
        if(heap.length == 0){
            System.out.println("Heap is empty, cannot delete");
            return;
        }
        //heap[0] = heap[heap.length-1];
        swap(heap,0,size-1);
        size--;
        heapifyDown(0);
    }
    void heapifyDown(int index) {
        int leftChild = leftChild(index);
        int rightChild = rightChild(index);
        int temp = index;

        if (leftChild < size && heap[leftChild].getActualS() - heap[leftChild].getTargetS() > heap[temp].getActualS() - heap[temp].getTargetS())
            temp = leftChild;

        if (rightChild < size && heap[rightChild].getActualS() - heap[rightChild].getTargetS() > heap[temp].getActualS() - heap[temp].getTargetS())
            temp = rightChild;

        if (temp != index) {
            swap(heap, index, temp);
            heapifyDown(temp);
        }
    }
    void heapSort(){
        int temp = size;
        for(int i=0; i<temp; i++){
            deleteRoot();
        }
        for(int i=0;i<temp;i++){
            System.out.print(heap[i]+ " ");
        }
        System.out.println();
    }
    void printHeap(){
        System.out.println("Max heap: ");
        for (int i=0;i<size;i++){
            System.out.print(heap[i]+" ");
        }
        System.out.println();
    }
}


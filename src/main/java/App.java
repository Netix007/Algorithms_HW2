import java.util.Random;

public class App {

    public static void main(String[] args) {
        int[] myArray = createArray(10);
        System.out.print("Исходный массив: ");
        printArray(myArray);
        System.out.print("Отсортированный массив: ");
        HeapSort obj = new HeapSort();
        obj.heapSort(myArray);
        printArray(myArray);
    }

    public static int[] createArray(int n) {
        Random randomize = new Random();
        int[] newArray = new int[n];
        for (int i = 0; i < n; i++) {
            newArray[i] = randomize.nextInt(100);
        }
        return newArray;
    }

    public static void printArray(int[] arr) {
        for (int elem : arr
        ) {
            System.out.print(elem + " ");
        }
        System.out.print("\n");
    }

    public static class HeapSort {

        public void heapSort(int[] arr) {
            int n = arr.length;

            // Построение кучи (перегруппируем массив)
            for (int i = n / 2 - 1; i >= 0; i--)
                heapify(arr, n, i);

            // Один за другим извлекаем элементы из кучи
            for (int i = n - 1; i >= 0; i--) {
                // Перемещаем текущий корень в конец
                int temp = arr[0];
                arr[0] = arr[i];
                arr[i] = temp;

                // Вызываем процедуру heapify на уменьшенной куче
                heapify(arr, i, 0);
            }
        }

        // Процедура для преобразования в двоичную кучу поддерева с корневым узлом i, что является
        // индексом в arr[]. n - размер кучи
        void heapify(int arr[], int n, int i) {
            int largest = i; // Инициализируем наибольший элемент как корень
            int l = 2 * i + 1; // левый = 2*i + 1
            int r = 2 * i + 2; // правый = 2*i + 2

            // Если левый дочерний элемент больше корня
            if (l < n && arr[l] > arr[largest])
                largest = l;

            // Если правый дочерний элемент больше, чем самый большой элемент на данный момент
            if (r < n && arr[r] > arr[largest])
                largest = r;
            // Если самый большой элемент не корень
            if (largest != i) {
                int swap = arr[i];
                arr[i] = arr[largest];
                arr[largest] = swap;

                // Рекурсивно преобразуем в двоичную кучу затронутое поддерево
                heapify(arr, n, largest);
            }
        }
    }
}

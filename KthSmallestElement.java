////Kth smallest element - Works - DONE

public class KthSmallestElement {
	private static int[] a;
	private static int size;
	private static int left;
	private static int right;
	private static int largest;

	public static void buildheap(int[] a) {
		size = a.length - 1;
		for (int i = size / 2; i >= 0; i--) {
			maxheap(a, i);
		}
	}

	public static void maxheap(int[] a, int i) {
		left = 2 * i;
		right = 2 * i + 1;
		if (left <= size && a[left] > a[i]) {
			largest = left;
		} else {
			largest = i;
		}

		if (right <= size && a[right] > a[largest]) {
			largest = right;
		}
		if (largest != i) {
			exchange(i, largest);
			maxheap(a, largest);
		}
	}

	public static void exchange(int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	public static void sort(int[] numbers) {
		a = numbers;
		buildheap(numbers);

		for (int i = size; i > 0; i--) {
			exchange(0, i);
			size -= 1;
			maxheap(a, 0);
		}
	}

	public static void main(String[] args) {
		int[] numbers = { 4, 1, 3, 2, 16, 9, 10, 14, 8, 7 };
		int needle = 6;
		sort(numbers);
		System.out.print("The Kth smallest element is: " + numbers[needle - 1] + " ");

	}
}

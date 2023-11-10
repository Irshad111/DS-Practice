package Sorting;

public class Sort {

	public static void main(String[] args) {
		int[] arr = { 10, 16, 8, 12, 15, 6, 3, 9, 5 };
		// BubbleSort(arr);
		// SelectionSort(arr);
		// int[] one = { 10, 20,30,40,50};
		// int[] two = { 5, 12, 17, 20 ,25,60,70,80};

		// int[] ans = mergeTwoSortedArrays(one, two);
		QuickSort(arr, 0, arr.length - 1);
		// InsertionSort(arr);
		for (int i : arr) {
			System.out.println(i);
		}
		// System.out.println(BinarySearch(arr, 7));

	}

	// bubble sort
	public static void BubbleSort(int[] arr) {
		for (int counter = 0; counter < arr.length - 1; counter++) {
			for (int i = 0; i < arr.length - 1 - counter; i++) {
				if (arr[i] > arr[i + 1]) {
					int temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
				}
			}
		}
	}

	// selection sort
	public static void SelectionSort(int[] arr) {
		for (int counter = 0; counter < arr.length - 1; counter++) {
			int min = counter;
			for (int i = counter + 1; i < arr.length; i++) {
				if (arr[i] < arr[min]) {
					min = i;
				}
			}
			int temp = arr[min];
			arr[min] = arr[counter];
			arr[counter] = temp;
		}
	}

	public static void InsertionSort(int[] arr) {
		for (int counter = 1; counter < arr.length; counter++) {
			int val = arr[counter];
			int i = counter - 1;
			while (i >= 0 && arr[i] > val) {
				arr[i + 1] = arr[i];
				i--;
			}
			arr[i + 1] = val;
		}
	}

	// binary search
	public static int BinarySearch(int[] arr, int item) {
		int hi = arr.length - 1;
		int lo = 0;
		while (lo <= hi) {
			int mid = (hi + lo) / 2;
			if (arr[mid] > item) {
				hi = mid - 1;
			} else if (arr[mid] < item) {
				lo = mid + 1;
			} else
				return mid;
		}
		return -1;

	}

	// merge sort
	public static int[] mergeTwoSortedArrays(int[] one, int[] two) {
		int[] merge = new int[one.length + two.length];
		int im = 0;
		int io = 0;
		int it = 0;
		// till same length
		while (io < one.length && it < two.length) {
			if (one[io] < two[it]) {
				merge[im] = one[io];
				io++;
			} else if (one[io] >= two[it]) {
				merge[im] = two[it];
				it++;
			}
			im++;
		}

		// if arry two is finished then for array one
		while (io < one.length) {
			merge[im] = one[io];
			io++;
			im++;
		}
		// if array one is finished then for array two
		while (it < two.length) {
			merge[im] = two[it];
			it++;
			im++;
		}

		return merge;

	}

	public static int[] mergeSort(int[] arr, int lo, int hi) {
		if (lo == hi) {
			int[] br = new int[1];
			br[0] = arr[lo];
			return br;
		}
		int mid = (lo + hi) / 2;
		int[] firsthalf = mergeSort(arr, lo, mid);
		int[] secondhalf = mergeSort(arr, mid + 1, hi);
		int[] sorted = mergeTwoSortedArrays(firsthalf, secondhalf);
		return sorted;
	}

	// String type array
	public static String[] mergeTwoSortedArray(String[] one, String[] two) {
		String[] merge = new String[one.length + two.length];
		int im = 0;
		int io = 0;
		int it = 0;
		// till same length
		while (io < one.length && it < two.length) {
			int cmp = two[it].compareTo(one[io]);
			if (cmp > 0) {
				merge[im] = one[io];
				io++;
			} else if (cmp <= 0) {
				merge[im] = two[it];
				it++;
			}
			im++;
		}

		// if arry two is finished then for array one
		while (io < one.length) {
			merge[im] = one[io];
			io++;
			im++;
		}
		// if array one is finished then for array two
		while (it < two.length) {
			merge[im] = two[it];
			it++;
			im++;
		}

		return merge;

	}

	public static String[] mergeSortToString(String[] arr, int lo, int hi) {
		if (lo == hi) {
			String[] br = new String[1];
			br[0] = arr[lo];
			return br;
		}
		int mid = (lo + hi) / 2;
		String[] firsthalf = mergeSortToString(arr, lo, mid);
		String[] secondhalf = mergeSortToString(arr, mid + 1, hi);
		String[] sorted = mergeTwoSortedArray(firsthalf, secondhalf);
		return sorted;
	}
	// quick

	public static int partition(int arr[], int lo, int hi) {
		int left = lo;
		int right = hi;
		int pivot = arr[lo];
		while (left < right) {
			while (arr[left] <= pivot)
				left++;
			while (arr[right] > pivot)
				right--;
			if (left < right) {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
			}

		}
		int temp = arr[lo];
		arr[lo] = arr[right];
		arr[right] = temp;

		return right;
	}

	public static void QuickSort(int arr[], int lo, int hi) {
		if (lo < hi) {
			int j = partition(arr, lo, hi);
			QuickSort(arr, lo, j - 1);
			QuickSort(arr, j + 1, hi);
		}
	}

	public static long sort(int[] arr, int l, int r) {
		long count = 0;
		if (l < r) {
			int mid = (l + r) / 2;
			count += sort(arr, l, mid);
			count += sort(arr, mid + 1, r);
			count += merge(arr, l, r);

		}
		return count;
	}

	public static long merge(int arr[], int l, int r) {
		int m = (l + r) / 2;
		int n1 = m - l + 1;
		int n2 = r - m;
		int k = l;
		int[] left = new int[n1];
		int[] right = new int[n2];
		for (int i = 0; i < n1; i++) {
			left[i] = arr[k++];
		}
		for (int j = 0; j < n2; j++) {
			right[j] = arr[k++];
		}
		int i = 0, j = 0;
		k = l;
		long count = 0;
		while (i < n1 && j < n2) {
			if (left[i] <= right[j]) {
				arr[k++] = left[i++];
			} else {
				arr[k++] = right[j++];
				count += m + 1 - (l + i);
			}
		}
		while (i < n1) {
			arr[k++] = left[i++];
		}
		while (j < n2) {
			arr[k++] = right[j++];
		}
		return count;
	}

}

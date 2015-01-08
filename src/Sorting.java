public class Sorting {
	public static void bucketSort(int[] num) {
		if (num == null)
			throw new NullPointerException("Null array!");
		int maxval = findLimit(num)[1];
		int minval = findLimit(num)[0];
		int[] buckets = new int[maxval - minval + 1];
		for (int n : num) {
			buckets[n - minval]++;
		}
		int index = 0;
		for (int i = 0; i < buckets.length; i++) {
			if (buckets[i] == 0)
				continue;
			for (int j = 0; j < buckets[i]; j++) {
				num[index++] = i + minval;
			}
		}
	}
	public static void bucketSortListNode (int[] num) {
		int maxval = findLimit(num)[1];
		int minval = findLimit(num)[0];
		int bucket_size = maxval;
		ListNode[] buckets = new ListNode[bucket_size];
		for (int i = 0; i < buckets.length; i++) {
			buckets[i] = null;
		}
		int range = (maxval - minval + 1) / bucket_size;
		for (int n : num) {
			int bucket = n / range - 1;
			if (bucket <= 0)
				bucket = 0;
			if (bucket >= bucket_size)
				bucket = bucket_size - 1;
			if (buckets[bucket] == null)
				buckets[bucket] = new ListNode(n);
			else {
				buckets[bucket] = addNode(buckets[bucket], new ListNode(n));
			}
		}
		int index = 0;
		for (int i = 0; i < bucket_size; i++) {
			ListNode node = buckets[i];
			while (node != null) {
				num[index++] = node.val;
				node = node.next;
			}
		}
	}
	private static ListNode addNode(ListNode head, ListNode toAdd) {
		ListNode node = head;
		if (node.next == null) {
			if (node.val < toAdd.val)
				node.next = toAdd;
			else{
				toAdd.next = node;
				head = toAdd;
			}
		}
		else {
			while (node.next != null && node.next.val < toAdd.val) 
				node = node.next;
			toAdd.next = node.next;
			node.next = toAdd;
		}
			
		return head;
	}
	public static int[] countingSort(int[] num) {
		if (num == null)
			throw new NullPointerException("Null array!");
		int maxval = findLimit(num)[1];
		int minval = findLimit(num)[0];
		int[] count = new int[maxval - minval + 1];
		for (int n : num) {
			count[n - minval]++;
		}
		for (int i = 1; i < count.length; i++) {
			count[i] += count[i - 1];
		}
		int[] rst = new int[num.length];
		for (int i = num.length - 1; i >= 0; i--) {
			int tmp = num[i] - minval;
			rst[--count[tmp]] = num[i];
		}
		return rst;
	}
	private static int[] findLimit(int[] num) {
		int[] limits = new int[2];
		limits[0] = Integer.MAX_VALUE;
		limits[1] = Integer.MIN_VALUE;
		for (int n : num) {
			limits[0] = Math.min(n, limits[0]);
			limits[1] = Math.max(n, limits[1]);
		}
		return limits;
	}
	public static void bubbleSort(int[] num) {
		boolean swapped = true;
		for (int i = num.length - 1; i > 0 && swapped; i--) {
			swapped = false;
			for (int j = 0; j < i; j++) {
				if (num[j] > num[j + 1]) {
					swap(num, j, j + 1);
					swapped = true;
				}
			}
		}
	}
	private static void swap(int[] num, int i, int j) {
		int tmp = num[i];
		num[i] = num[j];
		num[j] = tmp;
	}
	public static void selectionSort(int[] num) {
		for (int i = 0; i < num.length - 1; i++) {
			int index = i;
			for (int j = i + 1; j < num.length; j++) {
				if (num[j] < num[index])
					index = j;
			}
			swap(num, i, index);
		}
	}
	public static void insertionSort(int[] num) {
		for (int i = 0; i < num.length; i++) {
			int pivot = num[i];
			int j = i;
			//shift larger elements to the right
			while (j > 0 && pivot < num[j - 1]) {
				num[j] = num[j - 1];
				j--;
			}
			num[j] = pivot;
		}
	}
	public static void mergeSort(int[] num) {
		int[] tmp = new int[num.length];
		divide(num, tmp, 0, num.length - 1);
	}
	private static void divide(int[] num, int[] tmp, int left, int right) {
		if (left >= right)
			return;
		int mid = (left + right) / 2;
		divide(num, tmp, left, mid);
		divide(num, tmp, mid + 1, right);
		merge(num, tmp, left, mid + 1, right);
	}
	private static void merge(int[] num, int[] tmp, int leftStart, int rightStart, int rightEnd) {
		int leftEnd = rightStart - 1;
		int k = leftStart;
		int length = rightEnd - leftStart + 1;
		while (leftStart <= leftEnd && rightStart <= rightEnd) {
			//"=" maintain stability
			if (num[leftStart] <= num[rightStart])
				tmp[k++] = num[leftStart++];
			else
				tmp[k++] = num[rightStart++];
		}
		while (leftStart <= leftEnd)
			tmp[k++] = num[leftStart++];
		while (rightStart <= rightEnd)
			tmp[k++] = num[rightStart++];
		for (int i = 0; i < length; i++, rightEnd--) {
			num[rightEnd] = tmp[rightEnd];
		}
	}
	public static void quickSort(int[] num) {
		doQuickSort(num, 0, num.length - 1);
	}
	public static void doQuickSort(int[] num, int left, int right) {
		int index = partition(num, left, right);
		if(left < index - 1)
			doQuickSort(num, left, index - 1);
		if(index < right)
			doQuickSort(num, index, right);
	
	}
	private static int partition(int[] num, int left, int right) {
		int i = left; 
		int j = right;
		int pivot = num[(left + right) / 2];
		while (i <= j) {
			while (num[i] < pivot)
				i++;
			while(num[j] > pivot)
				j--;
			if (i <= j) {
				swap(num, i, j);
				i++;
				j--;
			}
		}
		return i;
	}
	
	public static void dualPivotQuickSort(int[] num) {
		doDualPivotQuickSort(num, 0, num.length - 1);
	}
	private static void doDualPivotQuickSort(int[] num, int low, int high) {
		if (low >= high)
			return;
		if (num[low] > num[high])
			swap(num, low, high);
		else if (num[low] == num[high]) {
			int tmp = num[low];
			while (num[low] == tmp && low < high) {
				low++;
			}
		}
		int lessThan = low + 1;
		int greatThan = high - 1;
		int index = low + 1;
		while (index <= greatThan) {
			if (num[index] < num[low]) {
				swap(num, lessThan, index);
				lessThan++;
				index++;
			}
			else if (num[high] < num[index]) {
				swap(num, index, greatThan);
				greatThan--;
			}
			else
				index++;
		}
		lessThan--;
		swap(num, low, lessThan);
		greatThan++;
		swap(num, high, greatThan);
		doDualPivotQuickSort(num, low, lessThan - 1);
		if (num[lessThan] < num[greatThan])
			doDualPivotQuickSort(num, lessThan + 1, greatThan - 1);
		doDualPivotQuickSort(num, greatThan + 1, high);
	}
	
	
	public static void heapSort(int[] num) {
		for (int i = num.length / 2 - 1; i >= 0; i--) {
			shiftDown(num, num.length, i);
		}
		int size = num.length;
		while (size > 0) {
			swap(num, 0, --size);
			/*for (int i = 0; i < num.length; i++) {
				System.out.print(num[i] + ", ");
			}
			System.out.println(" ");
			shiftDown(num, size, 0);*/
		}
		for (int i = 0, j = num.length - 1; i < j; i++, j--) {
			swap(num, i, j);
		}
	}
	private static void shiftDown(int[] num, int size, int index) {
		if (index >= size)
			return;
		int half = (size) / 2;
		int copy = num[index];
		while (index < half) {
			int child = 2 * index + 1;
			int right = child + 1;
			if (right < size && num[right] < num[child]) {
				child = right;
			}
			if (copy < num[child])
				break;
			num[index] = num[child];
			index = child;
		}
		num[index] = copy;
	}
	

}

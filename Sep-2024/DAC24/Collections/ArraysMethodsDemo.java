import java.util.*;

class ArraysMethodsDemo
{
	
	public static void printArr(Integer []arr)
	{
		for(int val : arr)
		{
			System.out.println(val);
		}
	}

	public static void main(String args[])
	{
		Integer arr[] = new Integer[]{5,2,7,1,3};
		System.out.println("Array elements:");
		printArr(arr);
		
		//toString()
		System.out.println("Output of Arrays.toString(arr):");
		String str = Arrays.toString(arr);
		System.out.println(str);

		//sort()
		Arrays.sort(arr);
		System.out.println("Output of Arrays.sort(arr):");
		System.out.println(Arrays.toString(arr));

		//binarySearch() : It is mandatory that array must be sorted first
		int idx = Arrays.binarySearch(arr,5);
		System.out.println("Output of Arrays.binarySearch(arr,5): " + idx);

		//fill()
		/*Arrays.fill(arr,-1);
		System.out.println("Output of Arrays.fill(arr,-1):");
		System.out.println(Arrays.toString(arr));*/

		//copyOf()
		Integer anotherArr[] = Arrays.copyOf(arr,10);
		System.out.println("Copied array elements with size 10: ");
		System.out.println(Arrays.toString(anotherArr));

		System.out.println("Array as list: ");
		List<Integer> numList = Arrays.asList(arr);
		Collections.reverse(numList);
		//Collections.sort(numList,Collections.reverseOrder());
		for(int num : numList)
		{
			System.out.println(num);
		}


	}
}

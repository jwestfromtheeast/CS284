/**
 * Sorting<E> Class, a simple class to practice sorting
 * CS 284-Q, Spring 2019
 */
package classroom;

public class Sorting<E extends Comparable<E>> {
    private E[] table;

    public Sorting(E[] items) {
        table = items;
    }

    public void bubbleSort() {
        int n = table.length; 
        for (int i = 0; i < n-1; i++)  {
            System.out.println(display());
            // Each pass, one more element is sorted (the last element each pass)
            for (int j = 0; j < n-i-1; j++)
                if (table[j].compareTo(table[j+1]) > 0)
                    { 
                        // swap table[j+1] and table[i] 
                        E temp = table[j]; 
                        table[j] = table[j+1]; 
                        table[j+1] = temp; 
                    }
        }
    }
    
    public void insertionSort() {
    	for(int i = 0; i < table.length - 1; i++) {
    		int next = i + 1;
    		do {
    			if(table[next - 1].compareTo(table[next]) > 0) {
    				E temp = table[next];
    				table[next] = table[next-1];
    				table[next-1] = temp;
    				next--;
    			} else {
    				break;
    			}
    		} while(next > 0);
    	}
    }
    
    public void mergeSort(E[] table) {
    	if (table.length > 1) {
    		int mid = table.length / 2;
    		@SuppressWarnings("unchecked")
			E[] leftTable = (E[]) new Comparable[mid];
    		@SuppressWarnings("unchecked")
			E[] rightTable = (E[]) new Comparable[table.length - mid];
    		System.arraycopy(table, 0, leftTable, 0, mid);
    		System.arraycopy(table, mid, rightTable, 0, table.length - mid);
    		mergeSort(leftTable);
    		mergeSort(rightTable);
    		merge(table, leftTable, rightTable);
    	}
    }
    
    public void merge(E[] out, E[] left, E[] right) {
    	int i = 0, j = 0, k = 0;
    	while(i < left.length && j < right.length) {
    		if(left[i].compareTo(right[j]) < 0) {
    			out[k] = left[i];
    			i++;
    		}
    		else {
    			out[k] = right[j];
    			j++;
    		}
    		k++;
    	}
    	
    	while(i < left.length) {
    		out[k] = left[i];
    		i++;
    		k++;
    	}
    	
    	while(j < right.length) {
    		out[k] = right[j];
    		j++;
    		k++;
    	}
    }

    public void sort() {
        mergeSort(table);
    }

    public String display() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < table.length; i++) { 
            sb.append(table[i].toString());
            sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        Integer[] t = { 5, 6, 1, 8, 2, 7, 4 };
        Sorting<Integer> s  = new Sorting(t);
        s.sort();
        System.out.println(s.display());
    }
}

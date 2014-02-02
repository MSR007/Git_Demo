package org.hashtable;


public class DSHashSet<T> implements DSSet<T> {

	private static final int INIT_BUCKETS = 11;
	private static final int BUCKET_SIZE = 2;
	ListNode<T> htbl [] ;
	int size ;
	int nBuckets;
	
	@SuppressWarnings("unchecked")
	public DSHashSet()
	{
		htbl = new ListNode [INIT_BUCKETS];
		size = 0;
		nBuckets = htbl.length;
		for(int i=0;i<nBuckets;i++)
		{
			htbl[i] = new ListNode<T>();
		}
	}
	
	
	@Override
	public boolean add(T element) {
		
		if(size/nBuckets>=BUCKET_SIZE)
		{
			rehash();
		}
		
		int key = hashCode(element);
		listAdd(htbl[key],element);
		size ++ ;
		return true;
	}
	@SuppressWarnings("unchecked")
	private void rehash()
	{
		int newBuckets = nBuckets*2;
		ListNode<T> newHtbl[] = new ListNode[newBuckets];
		for(int i=0;i<newBuckets;i++)
		{
			newHtbl[i] = new ListNode<T>();
		}
		for(int i=0;i<nBuckets;i++)
		{
			ListNode<T> curreNode = htbl[i];
			
			
			if(curreNode == null)
			{
				continue;
			}
			while(curreNode.next!=null)
			{
				T element = curreNode.element;
				int key = hashCode(element);
				listAdd(newHtbl[key], element);

			}
		
			
			
				
		}
		
		
	}

	@Override
	public boolean remove(T element) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T get(T element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public  boolean contains(T element) {
		
		int key = hashCode (element);
		return listFind(htbl[key], element);
	}
	
	private boolean listFind(ListNode<T> node ,T element )
	{
		ListNode<T> tmpNode = node;
		if(tmpNode == null)
		{
			return false;
		}
		while(tmpNode.next !=null)
		{
			if(tmpNode.element.equals(element))
			{
				return true;
			}
			tmpNode = tmpNode.next;
		}
		if(tmpNode.element.equals(element))
		{
			return true;
		}
		return false;
	}
	
	public int hashCode(T element)
	{
		int key = element.hashCode() % nBuckets;
		return key;
	}
	
	private void listAdd(ListNode<T> node ,T element)
	{
		
	}
}

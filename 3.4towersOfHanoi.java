/*
3.4Towers of hanoi.
*/


public class Tower {

	private Stack<Integer> disks;
	private int index;

	public Tower(int i){
		this.disks= new Stack<Integer>();
		this.index = i;
	} 

	public void add(int v){
		if(!disks.isEmpty()&& disks.peek()<=v){
			System.out.println("error placking disks");
			//error!!!
		}else{
			disk.push(v);
		}

	}

	public void moveTopto(Tower t){
		int v = disks.pop();
		t.add(v);
	}

	public void moveDisks(int n, Tower destination, Tower buffer){
		if(n>0){
			//recursive!!!!!!
			moveDisks(n-1, buffer, destination);
			moveTopto(destination);
			buffer.moveDisks(n-1,destination, this);

		}
	}

}

public static void main(String[] args){
		int n=3;
		Tower[] towers= new Tower[3];
		for(int i =0; i< 3;i++){
			towers[i]= new Tower(i);
		}

		for(int i = n-1; i>=0; i++){
			towers[0].add(i);
		}
		towers[0].moveDisks(n,towers[2], towers[1]);

	}

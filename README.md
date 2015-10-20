Welcome to SimpleParallelRunner
===================


Easy way to run parallel tasks on Java.

----------


Examples
-------------


###Database example:

```
public class TableRunner implements Runner {

	@Override public Object run(Object instance, ParallelParameter p) throws Exception {
		Connection conn = (Connection) instance;
		String query = (String) p.getInput();
		conn.execute(query);
	}


}
```


```
//Run your parallel querys

public void runParallelQuerys(Collection < String > querys, Collection < Connection > connections) throws Exception {

	RunnerPool instance = new RunnerPool();
	//every connection will be a thread
	instance.setInstances(connections);
	//set all the querys as parameters
	instance.setParams(querys);
	//Set the runner
	instance.setRunner(new TableRunner());
	//Run in parallel
	instance.runPool();

}
```

###Sum example:
```
//A container class
public class IntContainer {

	private int sum = 0;

	public void add(int val) {
		synchronized(this) {
			sum += val;
		}
	}
	public int getSum() {
		synchronized(this) {
			return sum;
		}
	}
	public void setSum(int sum) {
		synchronized(this) {
			this.sum = sum;
		}
	}
}
```


```
//A worker class
public class Sum implements Runner {

	@Override
	public Object run(Object instance, ParallelParameter p) throws Exception {
		IntContainer worker = (IntContainer) instance;
		Integer i = (Integer) p.getInput();
		worker.add(i);
		return null;

	}

}
```


```
//Run your pool
RunnerPool instance = new RunnerPool();
//Parameters
ArrayList < Integer > input = new ArrayList < Integer > ();

for (int i = 1; i <= max; i++) {
	//Add a parameter 
	input.add(1);
}

//Workers, every worker will be a thread
ArrayList workers = new ArrayList();
workers.add(new IntContainer());
workers.add(new IntContainer());
workers.add(new IntContainer());

instance.setInstances(workers);
instance.setParams(input);
instance.setRunner(new Sum());
instance.runPool();
//collect results:
int c = 0;
for (Object o: instance.getInstances()) {
	IntContainer w = (IntContainer) o;
	c += w.getSum();
}
System.out.print("Result:" + c);
```

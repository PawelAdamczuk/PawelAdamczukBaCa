//Pawel Adamczuk - 1
//Pseudo-linked-list implementation AKA the most fun exercise of the UJ computer science course AKA THOMAS
//The whole fuss is over the lists (trains) being connected rear-to-rear or head-to-head and handling all those unnatural cases. A coal fueled nightmare.

import java.util.Scanner;

public class Source {
  
  public static Train ThomasTheLittleEngine; //the first engine is Thomas. He always gets to play with the fresh, unused cars first.
  
  public static void delFirst(String trainName, String newTrainName) { //Thomas gets to play with a USED car, which is NOT okay.
    
    Train train = Source.ThomasTheLittleEngine;
    String carName;
    
    
    if (train.name.equals(trainName))
    {
      carName = train.first.name;
      if (train.first == train.last) //deleting the train
      {
        Source.ThomasTheLittleEngine = train.nextTrain;       
      }
      else
      {
        if (train.first.prev == null)
        {
          if (train.first == train.first.next.next)
          {
            train.first = train.first.next;
            train.first.next = null;
          }
          else //train.first == train.first.next.prev
          {
            train.first = train.first.next;
            train.first.prev = null;
          }
        }
        else //train.first.next == null
        {
          if (train.first == train.first.prev.prev)
          {
            train.first = train.first.prev;
            train.first.prev = null;
          }
          else //train.first == train.first.prev.next
          {
            train.first = train.first.prev;
            train.first.next = null;
          }          
        }        
      }
    }
    else
    {
      while (train.nextTrain !=  null  && !train.nextTrain.name.equals(trainName))
      {
        train = train.nextTrain;
      }
      if (train.nextTrain.first == train.nextTrain.last) //deleting the train
      {
       carName = train.nextTrain.first.name;
       train.nextTrain = train.nextTrain.nextTrain;        
      }
      else
      {
        train = train.nextTrain;
        carName = train.first.name;
        if (train.first.prev == null)
        {
          if (train.first == train.first.next.next)
          {
            train.first = train.first.next;
            train.first.next = null;
          }
          else //train.first == train.first.next.prev
          {
            train.first = train.first.next;
            train.first.prev = null;
          }
        }
        else //train.first.next == null
        {
          if (train.first == train.first.prev.prev)
          {
            train.first = train.first.prev;
            train.first.prev = null;
          }
          else //train.first == train.first.prev.next
          {
            train.first = train.first.prev;
            train.first.next = null;
          }          
        }
      }      
    }
    new Train(newTrainName, carName);
  }
  
  public static void delLast(String trainName, String newTrainName) { //Thomas gets to play with a USED car, which is NOT okay.
    
    Train train = Source.ThomasTheLittleEngine;
    String carName;
    
    
    if (train.name.equals(trainName))
    {
      carName = train.last.name;
      if (train.first == train.last) //deleting the train
      {
        Source.ThomasTheLittleEngine = train.nextTrain;       
      }
      else
      {
        if (train.last.prev == null)
        {
          if (train.last == train.last.next.next)
          {
            train.last = train.last.next;
            train.last.next = null;
          }
          else //train.first == train.first.next.prev
          {
            train.last = train.last.next;
            train.last.prev = null;
          }
        }
        else //train.first.next == null
        {
          if (train.last == train.last.prev.prev)
          {
            train.last = train.last.prev;
            train.last.prev = null;
          }
          else //train.first == train.first.prev.next
          {
            train.last = train.last.prev;
            train.last.next = null;
          }          
        }        
      }
    }
    else
    {
      while (train.nextTrain !=  null  && !train.nextTrain.name.equals(trainName))
      {
        train = train.nextTrain;
      }
      if (train.nextTrain.first == train.nextTrain.last) //deleting the train
      {
       carName = train.nextTrain.last.name;
       train.nextTrain = train.nextTrain.nextTrain;        
      }
      else
      {
        train = train.nextTrain;
        carName = train.last.name;
        if (train.last.prev == null)
        {
          if (train.last == train.last.next.next)
          {
            train.last = train.last.next;
            train.last.next = null;
          }
          else //train.first == train.first.next.prev
          {
            train.last = train.last.next;
            train.last.prev = null;
          }
        }
        else //train.first.next == null
        {
          if (train.last == train.last.prev.prev)
          {
            train.last = train.last.prev;
            train.last.prev = null;
          }
          else //train.first == train.first.prev.next
          {
            train.last = train.last.prev;
            train.last.next = null;
          }          
        }
      }      
    }
    new Train(newTrainName, carName);
  }
  
  public static void insertLast (String trainName, String carName) {
    
    Train train = Source.ThomasTheLittleEngine;
    while (!train.name.equals(trainName))
    {
      train = train.nextTrain;
    }
    
    Car car = new Car(carName);
    
    if (train.last.next == null)
    {
      train.last.next = car;
      car.prev = train.last;
      train.last = car;
      car.next = null;
    }
    else
    {
      train.last.prev = car;
      car.next = train.last;
      train.last = car;
      car.prev = null;
    }
    
  }
  
  public static void insertFirst (String trainName, String carName) {
    
    Train train = Source.ThomasTheLittleEngine;
    while (!train.name.equals(trainName))
    {
      train = train.nextTrain;
    }
    
    Car car = new Car(carName);
    
    if (train.first.prev == null)
    {
      train.first.prev = car;
      car.next = train.first;
      train.first = car;
      car.prev = null;
    }
    else
    {
      train.first.next = car;
      car.prev = train.first;
      train.first = car;
      car.next = null;
    }
    
  }
    
  public static void union(String baseTrainName, String attachmentTrainName) {
    Train baseTrain = null;
    Train attachmentTrain = null;
    Train train = Source.ThomasTheLittleEngine;
    
    if (train.name.equals(attachmentTrainName)) //the attachment train is the first train on the list
    {
      attachmentTrain = train;
      Source.ThomasTheLittleEngine = attachmentTrain.nextTrain;
      train = attachmentTrain.nextTrain;
    }
    
    while (baseTrain == null || attachmentTrain == null)
    {
      
      if (train.name.equals(baseTrainName))
        baseTrain = train;
      
      if (train.nextTrain != null && train.nextTrain.name.equals(attachmentTrainName))
      {
        attachmentTrain = train.nextTrain;
        train.nextTrain = attachmentTrain.nextTrain;
      }
      
      train = train.nextTrain;      
    }
    
    if (baseTrain.last.next == null)
    {
      baseTrain.last.next = attachmentTrain.first;      
    }
    else //baseTrain.last.prev == null
    {
      baseTrain.last.prev = attachmentTrain.first;
    }
    
    if (attachmentTrain.first.next == null)
    {
      attachmentTrain.first.next = baseTrain.last;
    }
    else // attachmentTrain.first.prev == null
    {
      attachmentTrain.first.prev = baseTrain.last;
    }
    
    baseTrain.last = attachmentTrain.last;
    
    
    
  }
   
  public static void reverse(String trainName) {
    
    Train train = Source.ThomasTheLittleEngine;
    while (!train.name.equals(trainName))
    {
      train = train.nextTrain;
    }
    
    Car temp;
    temp = train.first;
    train.first = train.last;
    train.last = temp;
  }
  
  public static void listTrains() {
    System.out.print("Trains:");
    Train train = Source.ThomasTheLittleEngine;
    while (true)
    {
      System.out.print(" " + train.name);
      if (train.nextTrain == null)
        break;
      train = train.nextTrain;
    }
    System.out.print("\n");
  }
  
  public static void displayTrain(String trainName) {
    Train train = Source.ThomasTheLittleEngine;
    while (!train.name.equals(trainName))
    {
      train = train.nextTrain;
    }
    
    System.out.print(train.name + ":" );
    
    //String lastPrinted;
    
    boolean direction; // 1 - next // 0 - prev
    
    Car car = train.first;
    
    if (car.prev == null)
      direction = true;
    else
      direction = false;
    
    while (true)
    {
      System.out.print(" " + car.name);
      
      if (direction && car.next == null) // finish
        break;
      if (!direction && car.prev == null) // finish
        break;
      
      if (direction)
      { // next
        if (car == car.next.next)
        {
          car = car.next;
          direction = false;
        }
        else
        {
          car = car.next;
        }
      }
      else
      { // prev
        if (car == car.prev.prev)
        {
          car = car.prev;
          direction = false;
        }
        else
        {
          car = car.prev;
        }
      }
      
    }
    
    System.out.print("\n");
    
    
  }
  
  public static class Car {
    String name;
    Car next;
    Car prev;
    
    public Car(String name, Car next, Car prev) {
      super();
      this.name = name;
      this.next = next;
      this.prev = prev;
    }
    
    public Car(String name) {
      super();
      this.name = name;
      this.next = null;
      this.prev = null;
    }
  
  }
  
  public static class Train {
    Car first;
    Car last;
    String name;
    Train nextTrain;
    
    public Train(String trainName, String firstCarName) {
      super();
      Car firstCar = new Car(firstCarName);
      this.first = firstCar;
      this.last = firstCar;
      this.name = trainName;
      this.nextTrain = Source.ThomasTheLittleEngine;
      Source.ThomasTheLittleEngine = this;
    }
  }
  
	public Source() {
	}

	public static void main(String[] args) {
//	  new Train("A", "a");
//	  insertLast("A", "b");
//    insertFirst("A", "c");
//    Source.displayTrain("A");
//    
//    new Train("B", "d");
//    Source.displayTrain("B");
//    reverse("A");
//    Source.listTrains();
//    //union("A", "B");
//    Source.delLast("B", "Q");
//    Source.listTrains();
//    //Source.delFirst("A", "D");
//    //Source.delLast("A", "D");
//    Source.displayTrain("A");
//    Source.listTrains();
	  
	  Scanner mainScanner = new Scanner(System.in);
	  int setCount = mainScanner.nextInt();
	  int instructionCount;
	  String instruction;
	  String param1;
	  String param2;
	  
	  for (int i = 0; i < setCount; ++i)
	  {
	    Source.ThomasTheLittleEngine = null;
	    instructionCount = mainScanner.nextInt();
	    for (int j = 0; j < instructionCount; ++j)
	    {
	      instruction = mainScanner.next();
	      if (instruction.equals("New"))
	      {
	        param1 = mainScanner.next();
	        param2 = mainScanner.next();
	        new Train(param1, param2);
	      }
	      else if (instruction.equals("InsertFirst"))
	      {
	        param1 = mainScanner.next();
          param2 = mainScanner.next();
          insertFirst(param1, param2);
	      }
	      else if (instruction.equals("InsertLast"))
        {
	        param1 = mainScanner.next();
          param2 = mainScanner.next();
          insertLast(param1, param2);
        }
	      else if (instruction.equals("Display"))
        {
	        param1 = mainScanner.next();
          displayTrain(param1);
        }
	      else if (instruction.equals("TrainsList"))
        {
	        listTrains();
        }
	      else if (instruction.equals("Reverse"))
        {
	        param1 = mainScanner.next();
          reverse(param1);
        }
	      else if (instruction.equals("Union"))
        {
	        param1 = mainScanner.next();
          param2 = mainScanner.next();
          union(param1, param2);
        }
	      else if (instruction.equals("DelFirst"))
        {
	        param1 = mainScanner.next();
          param2 = mainScanner.next();
          delFirst(param1, param2); 
        }
	      else if (instruction.equals("DelLast"))
        {
	        param1 = mainScanner.next();
          param2 = mainScanner.next();
          delLast(param1, param2);
        }
	    }	    
	  }
	  
	  mainScanner.close();
    
	}

}

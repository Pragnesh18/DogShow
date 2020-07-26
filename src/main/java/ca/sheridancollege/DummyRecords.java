package ca.sheridancollege;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.sheridancollege.DogContainer.Breed;
import ca.sheridancollege.DogContainer.DogClass;
import ca.sheridancollege.DogContainer.DogGroup;
import ca.sheridancollege.DogContainer.DogName;
import ca.sheridancollege.DogContainer.Gender;
import ca.sheridancollege.DogContainer.OwnerName;
import ca.sheridancollege.DAO.DAO;
import ca.sheridancollege.beans.Dog;

class RandomName<E extends Enum<DogContainer.DogName>> {
	  Random RND = new Random();
	  E[] values;

	  public RandomName(Class<E> token) {
	    values = token.getEnumConstants();
	  }

	  public E random() {
	    return values[RND.nextInt(values.length)];
	  }
}

class RandomOwner<E extends Enum<DogContainer.OwnerName>> {
	  Random RND = new Random();
	  E[] values;

	  public RandomOwner(Class<E> token) {
	    values = token.getEnumConstants();
	  }

	  public E random() {
	    return values[RND.nextInt(values.length)];
	  }
}

class RandomBreed<E extends Enum<DogContainer.Breed>> {
	  Random RND = new Random();
	  E[] values;

	  public RandomBreed(Class<E> token) {
	    values = token.getEnumConstants();
	  }

	  public E random() {
	    return values[RND.nextInt(values.length)];
	  }
}

class RandomGroup<E extends Enum<DogContainer.DogGroup>> {
	  Random RND = new Random();
	  E[] values;

	  public RandomGroup(Class<E> token) {
	    values = token.getEnumConstants();
	  }

	  public E random() {
	    return values[RND.nextInt(values.length)];
	  }
}

class RandomGender<E extends Enum<DogContainer.Gender>> {
	  Random RND = new Random();
	  E[] values;

	  public RandomGender(Class<E> token) {
	    values = token.getEnumConstants();
	  }

	  public E random() {
	    return values[RND.nextInt(values.length)];
	  }
}

class RandomClass<E extends Enum<DogContainer.DogClass>> {
	  Random RND = new Random();
	  E[] values;

	  public RandomClass(Class<E> token) {
	    values = token.getEnumConstants();
	  }

	  public E random() {
	    return values[RND.nextInt(values.length)];
	  }
}


public class DummyRecords extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		for(int i = 0; i <= 100; i++) {
			RandomName<DogName> one = new RandomName<DogName>(DogName.class);
			RandomOwner<OwnerName> two = new RandomOwner<OwnerName>(OwnerName.class);
			RandomBreed<Breed> three = new RandomBreed<Breed>(Breed.class);
			RandomGroup<DogGroup> four = new RandomGroup<DogGroup>(DogGroup.class);
			RandomGender<Gender> five = new RandomGender<Gender>(Gender.class);
			RandomClass<DogClass> six = new RandomClass<DogClass>(DogClass.class);
			
			String number = "Null";
			String name = String.valueOf(one.random());
			String owner = String.valueOf(two.random());
			String breed = String.valueOf(three.random());
			String group = String.valueOf(four.random());
			String gender = String.valueOf(five.random());
			String dogclass = String.valueOf(six.random());
			
			if (breed == "Labrador_Retriever" || breed == "Nova_Scotia_Duck_Tolling_Retriever"
					|| breed == "Golden_Retriever") {
				group = "Group 1: Sporting Dogs";
			} else if (breed == "Beagle" || breed == "Dachshund"
					|| breed == "Greyhound" || breed == "Whippet") {
				group = "Group 2: Hounds";
			} else if (breed == "Boxer" || breed == "Siberian_husky"
					|| breed == "Dobermann" || breed == "Great_dane" 
					|| breed == "Akita" || breed == "Rottweiler" 
					|| breed == "English_Mastiff" || breed == "Newfoundland_dog") {
				group = "Group 3: Working Dogs";
			} else if (breed == "Bull_terrier" || breed == "Yorkshire_terrier") {
				group = "Group 4: Terriers";
			} else if (breed == "Chihuahua" || breed == "Maltese_dog"
					|| breed == "Shih_tzu" || breed == "Pomeranian") {
				group = "Group 5: Toys";
			} else if (breed == "Pug" || breed == "Poodle"
					|| breed == "French_bulldog" || breed == "Chow_chow" || breed == "Bulldog") {
				group = "Group 6: Non-sporting Dogs";
			} else if (breed == "German_Shepherd" || breed == "Border_collie"
					|| breed == "Old_English_Sheepdog") {
				group = "Group 7: Herding";
			}
			
			if(dogclass == "Specialty_dog") {
				dogclass = "Specialty Dog";
			} else if (dogclass == "Class_dog") {
				dogclass = "Class Dog";
			}
			
			if(breed == "Nova_Scotia_Duck_Tolling_Retriever") {
				breed = "Nova Scotia Duck Tolling Retriever";
			} else if(breed == "Border_collie") {
				breed = "Border Collie";
			} else if(breed == "Old_English_Sheepdog") {
				breed = "Old English Sheepdog";
			} else if(breed == "Newfoundland_dog") {
				breed = "Newfoundland Dog";
			} else if(breed == "Bull Terrier") {
				breed = "Bull Terrier";
			} else if(breed == "English_Mastiff") {
				breed = "English Mastiff";
			} else if(breed == "Yorkshire_terrier") {
				breed = "Yorkshire Terrier";
			} else if(breed == "French_bulldog") {
				breed = "French Bulldog";
			} else if(breed == "Siberian_husky") {
				breed = "Siberian Husky";
			} else if(breed == "Maltese_dog") {
				breed = "Maltese dog";
			} else if(breed == "Golden_Retriever") {
				breed = "Golden Retriever";
			} else if(breed == "Labrador_Retriever") {
				breed = "Labrador Retriever";
			} else if(breed == "German_Shepherd") {
				breed = "German Shepherd";
			} else if(breed == "Shih_tzu") {
				breed = "Shih Tzu";
			} else if(breed == "Great_dane") {
				breed = "Great Dane";
			} else if(breed == "Chow_chow") {
				breed = "Chow Chow";
			} else if(breed == "Bull_terrier") {
				breed = "Bull Terrier";
			} 
			
			Dog dummydogs = new Dog(number, name, owner, breed, group, gender, dogclass);
			
			DAO.addDogs(dummydogs);
			
		}
		
			}
	

}

public class Controller {
	public static void main(String[] args) {
		if (args.length > 0) {
			if (args[0].equals("test")) {
				//create some pieces of clothing and an outfit
				//TODO: junit test
				Torso tshirt1 = new Torso();
				Torso tshirt2 = new Torso();
				Legs shorts = new Legs();
				tshirt1.setTemperatureRating(5);
				tshirt2.setTemperatureRating(11);
				shorts.setTemperatureRating(5);
				
				Outfit outfit1 = new Outfit(new Torso[]{tshirt1, tshirt2}, new Legs[]{shorts});
				System.out.println(outfit1.getTemperatureRating());
				System.out.println("test complete");
			}
		}
	}
}

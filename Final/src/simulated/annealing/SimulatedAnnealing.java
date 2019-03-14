
package simulated.annealing;

import java.io.*;


public class SimulatedAnnealing {

    public static void main(String[] args) {
        // Command line args
        System.out.println("Command line args: ");
        for(int i=0;i< args.length;i++) {
            System.out.println(i + ": " + args[i]);
        }

        String line;
        //test-input-7,,,,
        //try (FileReader fr = new FileReader("/Users/mccallm/Documents/GitHub/CS420_Final_Project/Final/src/simulated/annealing/inputs/test-input-1.txt")) {
        try (FileReader fr = new FileReader(args[0])) {
            BufferedReader bufferedReader = new BufferedReader(fr);
            while ((line = bufferedReader.readLine()) != null) {
                int i = 0;
                String[] ss =  line.split("\\s+");
                if(ss[0].isEmpty()){i = 1;}
                int id = Integer.valueOf(ss[0+i]);
                int x = Integer.valueOf(ss[1+i]);
                int y = Integer.valueOf(ss[2+i]);
                City c = new City(id,x,y);
                TourManager.addCity(c);
                //readingLines.add(line); //4
            }
            bufferedReader.close();

        } catch (Exception e) {
        }

        //Set initial temp
        double temp = 1000000;
        //Cooling rate
        double coolingRate = 0.0000001;

        // Start timing the algorithm
        long startTime = System.currentTimeMillis();

        //create random intial solution
        Tour currentSolution = new Tour();
        currentSolution.tsp(); //generateIndividual();
        
        System.out.println("\nTotal distance of initial solution: " + currentSolution.getTotalDistance());
        System.out.println("Tour: " + currentSolution);

        // We would like to keep track if the best solution
        // Assume best solution is the current solution
        Tour best = new Tour(currentSolution.getTour());
        
        // Loop until system has cooled
        while (temp > 1) {
            // Create new neighbour tour
            Tour newSolution = new Tour(currentSolution.getTour());

            // Get random positions in the tour
            int tourPos1 = Utility.randomInt(0 , newSolution.tourSize());
            int tourPos2 = Utility.randomInt(0 , newSolution.tourSize());
            
            //to make sure that tourPos1 and tourPos2 are different
    		while(tourPos1 == tourPos2) {tourPos2 = Utility.randomInt(0 , newSolution.tourSize());}

            // Get the cities at selected positions in the tour
            City citySwap1 = newSolution.getCity(tourPos1);
            City citySwap2 = newSolution.getCity(tourPos2);

            // Swap them
            newSolution.setCity(tourPos2, citySwap1);
            newSolution.setCity(tourPos1, citySwap2);
            
            // Get energy of solutions
            int currentDistance   = currentSolution.getTotalDistance();
            int neighbourDistance = newSolution.getTotalDistance();

            // Decide if we should accept the neighbour
            double rand = Utility.randomDouble();
            double acc = Utility.acceptanceProbability(currentDistance, neighbourDistance, temp);
            if ( (acc ) > rand) {
                currentSolution = new Tour(newSolution.getTour());
            }

            // Keep track of the best solution found
            if (currentSolution.getTotalDistance() < best.getTotalDistance()) {
                best = new Tour(currentSolution.getTour());
            }
            
            // Cool system
            temp *= 1 - coolingRate;
        }

        // End timer
            long endTime = System.currentTimeMillis();

        // Output results to screen
            System.out.println("Final solution distance: " + best.getTotalDistance());
            System.out.println("TSP Alg took: " + (endTime - startTime) + " milliseconds");
            System.out.println("\t" + (endTime - startTime) / 1000 + " seconds");

        // File output
            String out_file = args[0].concat(".tour");
            System.out.println("Output file: " + out_file);

        // Check if output has already been generated
            File tmpFile = new File(out_file);
            System.out.println("Tour exists: " + tmpFile.exists());

        // If file exists: perform comparisons
            if(tmpFile.exists()) {
                try (FileReader freader = new FileReader(out_file)) {
                    // Capture the tour length in saved file in string 'line'
                    BufferedReader bufferedReader = new BufferedReader(freader);
                    line = bufferedReader.readLine();
                    bufferedReader.close();

                    // Compare previous tour length: only update if new tour is shorter
                    if(Integer.valueOf(line) > best.getTotalDistance()) {
                        // If saved tour is larger, overwrite with new results
                        System.out.println("\tGenerated tour is better than saved tour: overwriting with improved result...");
                        try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(out_file), "utf-8"))) {
                            // First Line --> Tour length
                            writer.write( String.valueOf(best.getTotalDistance())) ;
                            // N lines --> City ID in order of tour
                            for (int z = 0; z < best.tourSize(); z++){
                                City cityname = best.getCity(z);
                                writer.write("\n" + String.valueOf(cityname.getid()) );
                            }
                        } catch (IOException ex) { }
                    }
                    else {
                        // Else the generated tour is already shorter and we do nothing
                        System.out.println("\tSaved tour is better than generated tour: keeping old file.");
                    }
                } catch (Exception e) { }
            }
        // If doesn't exist: write to new file
        else {
            System.out.println("\tNo previous tour exists: saving results to file...");
            try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(out_file), "utf-8"))) {
                // First Line --> Tour length
                writer.write( String.valueOf(best.getTotalDistance())) ;
                // N lines --> City ID in order of tour
                for (int z = 0; z < best.tourSize(); z++){
                    City cityname = best.getCity(z);
                    writer.write("\n" + String.valueOf(cityname.getid()) );
                }
            }
            catch (IOException ex) { }
        }
    }
}

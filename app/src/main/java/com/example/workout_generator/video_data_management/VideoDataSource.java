package com.example.workout_generator.video_data_management;

import java.util.ArrayList;

public class VideoDataSource {

    //Number of videos constant
    private static final int numberOfVideos = 21;

    //Videos
    private final ArrayList<Video> videos = new ArrayList<>(0);

    //Info
    private final ArrayList<String> ids          = new ArrayList<>(0);
    private final ArrayList<String> links        = new ArrayList<>(0);
    private final ArrayList<String> titles       = new ArrayList<>(0);
    private final ArrayList<String> genders      = new ArrayList<>(0);
    private final ArrayList<String> locations    = new ArrayList<>(0);
    private final ArrayList<Double> durations    = new ArrayList<>(0);
    private final ArrayList<String> descriptions = new ArrayList<>(0);

    VideoDataSource(){
        //Default constructor
    }

    ArrayList<Video> getVideoList() {

        if(this.videos.size() == 0){
            throw new IllegalStateException("Method getVideoList() was invoked at an inappropriate time. " +
                    "Class variable ArrayList<Video> videos has not yet been initialized.\n\n" +
                    "Potential solution: call initializeVideoArray() before retrieving list of videos.");
        }
        else {
            return this.videos;
        }

    }

    //Set ArrayList of Videos
    void initializeVideoArray(){

        initializeDataArrays();

        for(int i = 0; i < numberOfVideos; i++){

            Video video = new Video(
                    ids.get(i),
                    links.get(i),
                    titles.get(i),
                    genders.get(i),
                    locations.get(i),
                    durations.get(i),
                    descriptions.get(i)
            );

            videos.add(i, video);

        }

    }

    //Initialize all the data
    private void initializeDataArrays(){


        /*
            SET THE IDs
         */
        ids.add("home_m_1");
        ids.add("home_m_2");
        ids.add("home_m_3");
        ids.add("home_f_1");
        ids.add("home_f_2");
        ids.add("home_f_3");

        ids.add("office_1");
        ids.add("office_2");
        ids.add("office_3");

        ids.add("gym_m_1");
        ids.add("gym_m_2");
        ids.add("gym_m_3");
        ids.add("gym_f_1");
        ids.add("gym_f_2");
        ids.add("gym_f_3");

        ids.add("outdoor_m_1");
        ids.add("outdoor_m_2");
        ids.add("outdoor_m_3");
        ids.add("outdoor_f_1");
        ids.add("outdoor_f_2");
        ids.add("outdoor_f_3");


        /*
            SET THE LINKS
         */
        links.add("UoC_O3HzsH0");
        links.add("IeGrTqW5lek");
        links.add("iCQ2gC4DqJw");
        links.add("rI_6l992GrA");
        links.add("IT94xC35u6k");
        links.add("bTo4NrSriWw");

        links.add("ytLAobeZrbE");
        links.add("E00Utc1QQqA");
        links.add("0Dp2rL397jA");

        links.add("ixkQaZXVQjs");
        links.add("1v0yYf0PiRk");
        links.add("r3h1Nf-wY6Y");
        links.add("Im5wJLdudDg");
        links.add("sthD8ziGP1c");
        links.add("hsjwYICtWiQ");

        links.add("8mOrDuV1EBU");
        links.add("kUV-nqsvlGk");
        links.add("OFSRp_6koe4");
        links.add("0ffuCBnGmQg");
        links.add("727Kkkwy9cQ");
        links.add("ioZYglRIVzA");


        /*
            SET THE TITLES
         */
        titles.add("10 Minutes Full Body Workout");
        titles.add("20 Minutes Full Body Workout");
        titles.add("20 Minutes Full Body Workout");
        titles.add("30 Minutes Full Body HIT");
        titles.add("20 Minutes for Beginners");
        titles.add("20 Minutes Intense Workout");

        titles.add("10 Minutes Exercise at Work");
        titles.add("10 Minutes Chair Exercise for Beginners");
        titles.add("10 Minutes General Office Workout");

        titles.add("Beginners Gym Workout");
        titles.add("Machines Only Gym Workout Program");
        titles.add("DEMO: How to Use Gym Equipment");
        titles.add("Total Body Training");
        titles.add("Full Week Workout - Complete");
        titles.add("Week of Workout for Women");

        titles.add("Outside No Equipment Exercise");
        titles.add("Quick Outdoor Workout Program");
        titles.add("Full Body Outdoors");
        titles.add("Beginner Outdoor Workout");
        titles.add("Outdoor Full Body Workout");
        titles.add("Outdoor Travel Exercise Training");


        /*
            SET THE GENDERS
         */
        genders.add("m");
        genders.add("m");
        genders.add("m");
        genders.add("f");
        genders.add("f");
        genders.add("f");

        genders.add("m/f");
        genders.add("m/f");
        genders.add("m/f");

        genders.add("m");
        genders.add("m");
        genders.add("m");
        genders.add("f");
        genders.add("f");
        genders.add("f");

        genders.add("m");
        genders.add("m");
        genders.add("m");
        genders.add("f");
        genders.add("f");
        genders.add("f");


        /*
            SET THE LOCATIONS
         */
        locations.add("home");
        locations.add("home");
        locations.add("home");
        locations.add("home");
        locations.add("home");
        locations.add("home");

        locations.add("office");
        locations.add("office");
        locations.add("office");

        locations.add("gym");
        locations.add("gym");
        locations.add("gym");
        locations.add("gym");
        locations.add("gym");
        locations.add("gym");

        locations.add("outdoor");
        locations.add("outdoor");
        locations.add("outdoor");
        locations.add("outdoor");
        locations.add("outdoor");
        locations.add("outdoor");


        /*
            SET THE DURATIONS
         */
        durations.add(10.56);
        durations.add(20.26);
        durations.add(20.31);
        durations.add(31.46);
        durations.add(22.18);
        durations.add(20.13);

        durations.add(11.55);
        durations.add(12.59);
        durations.add(2.26);

        durations.add(13.14);
        durations.add(10.33);
        durations.add(18.47);
        durations.add(8.32);
        durations.add(13.2);
        durations.add(23.53);

        durations.add(27.55);
        durations.add(10.3);
        durations.add(8.15);
        durations.add(11.5);
        durations.add(20.36);
        durations.add(20.29);


        /*
            SET THE DESCRIPTIONS
         */
        descriptions.add("Get ready for one of the best Home Workouts of your LIFE! Let's do this!\n" +
                "\n" +
                "A full body workout that you can do whenever and wherever you like... even before bed! You don't need any equipment or weight. This video is full length which means you can just follow along with whatever I'm doing. If you need extra rest, just pause the video. If you don't need a rest - watch it the whole way through. You can hit this home workout 2-3x per week - and if you wanted to keep active on your other days - be sure to check out my other workouts!");
        descriptions.add("Get ready for one of the best Home Workouts of your LIFE! Let's do this! \n" +
                "\n" +
                "A 20 minute full body workout that you can do whenever and wherever you like... even first thing in the morning! You don't need any equipment or weight. This video is full length which means you can just follow along with whatever I'm doing. \n" +
                "\n" +
                "If you need extra rest, just pause the video. If you don't need a rest - watch it the whole way through. You can hit this home workout 2-3x per week - and if you wanted to keep active on your other days - be sure to check out my other workouts!");
        descriptions.add("Lets gooooooo! Another perfect 20 MINUTE WORKOUT FOR BEGINNERS! Certainly for gain goals!");
        descriptions.add("Do this 30 minute FULL BODY WORKOUT #WithMe ! \n" +
                "\n" +
                "This workout is APARTMENT FRIENDLY as it has NO JUMPING and requires NO EQUIPMENT! #HomeWorkout #Fitness");
        descriptions.add("A 20 min fat burning, full body workout you can do at home without any equipment! A workout designed for TOTAL BEGINNERS! \n" +
                "\n" +
                "Wether you are just getting into fitness, or are getting back in the fitness game... this one is for you.");
        descriptions.add("Do This Every Morning To Feel Fit! \n" +
                "\n" +
                "It's a twenty minute full body workout that you can do ANYWHERE and at ANYTIME! If you ever feel like you need more rest, an extra break or modify an exercise - do so! it's time to get started sooo.. are you ready to LEVEL UP?");


        descriptions.add("Tired of the gym? UVA-WorkMed's Jolene Bodily demonstrates exercises you can do in ten minutes, in your office, in work clothes.");
        descriptions.add("This 10 Minute Chair Workout For Weight Loss with NO EQUIPMENT will make you feel great! Chair workout has never been more fun than now. You can finally get in shape while you sit without the use of expensive equipment or having to go to some germ-infested gym. \n" +
                "\n" +
                "Today's chair workout is all about consistent movement with no rest breaks for a total of 10 minutes. We transition from one move to the next every 30 seconds. This routine will challenge you in ways you never thought possible. \n" +
                "\n" +
                "I am going to push you to break FREE from those EXCUSES and grasp greatness. Chair workouts are believed to be for the old or crippled. But I'm here to prove that 100% incorrect. You will feel your shoulders, legs, stomach, and many other parts of your body being worked. Chair workouts are excellent if you find yourself short on time, have an injury that prevents you from doing certain things, and are very useful if you're sitting down all day. I am confident that you will get amazing RESULTS when you do my chair workouts. You are going to get sweaty and feel the burn in a matter of minutes. As a matter of fact, all I need from you is just 10 minutes.");
        descriptions.add("Don't worry about rushing home after work to get to the gym. Get a workout while you work. Here are a few simple exercises you can do right at your desk.");


        descriptions.add("If you are new to training and looking for a beginner workout to build muscle then this is the step by step workout plan you need. In this video, I take you through a workout for beginners that is 3 months in length, or possibly even longer if you decide to stick with the third month longer, that is designed to build both strength and muscle while making sure to build your body on a solid foundation. \n" +
                "\n" +
                "Each month consists of three workouts, two of which are full body workouts and one of which focuses on your core and grip/forearm strength. The total body workouts are alternated on monday, wednesday and friday while the core and carry workout is repeated every tuesday and thursday. The weekends are taken off for rest and recovery. The exercises in this beginner workout routine are grouped by movement patterns. Instead of focusing solely on specific exercises, I want the beginner trainee to think about how their bodies are moving and why that movement is important so that they may substitute in other exercises down the line with a knowledge of why they are acceptable alternatives. \n" +
                "\n" +
                "The ten movement patterns are:\n" +
                "Squat\n" +
                "Hinge\n" +
                "Vertical Push\n" +
                "Vertical Pull\n" +
                "Horizontal Push\n" +
                "Horizontal Pull\n" +
                "Static Lunge\n" +
                "Dynamic Lunge\n" +
                "Core Flexion\n" +
                "Carry");
        descriptions.add("Here's a beginners workout routine in the gym. \n" +
                "\n" +
                "Remember to shoot for 4 sets of 10-12 reps for each exercise. Focus on form! The exercises I show you in this video are:\n" +
                "Leg press, \n" +
                "leg extension, \n" +
                "leg curl, \n" +
                "seated chest press, \n" +
                "seated overhead press, \n" +
                "and seated row. \n" +
                "\n" +
                "-Brix");
        descriptions.add("This video is for people looking for a workout program targeted toward muscle growth and fat loss. You will learn how to do the most effective and fundamental exercise in the gym including, squats, bench press, curls, deadlifts, military press, core exercises, and more.");
        descriptions.add("Here's my total body strength training gym routine which targets all the major muscles, your legs, back, chest, shoulders, arms and core. Working on your entire body is key to build strength and to lose weight. \n" +
                "\n" +
                "Do these exercises 2 - 3 times weekly. Don't forget to also fit in your HIIT and cardio workout. Record a video or take a picture of you doing the workout, tag me @JoannaSohOfficial #JSohActive \n" +
                "\n" +
                "Joanna is a certified Personal Trainer (ACE), Women’s Fitness Specialist (NASM) and Nutrition Coach, with over 8 years of experience.");
        descriptions.add("Hello, my babes!\n" +
                "\n" +
                "In this video, I'll be walking you through a full week of workouts for beginners at the gym. In this week, we'll be doing three workouts: one full body workout, a lower body day, and lastly, an upper body workout.");
        descriptions.add("WEEK OF WORKOUTS | My Workout Routine | 4 Day Workout Split | Workouts for Women");


        descriptions.add("Try this workout routine ANYWHERE at ANYTIME.. no excuses!!!");
        descriptions.add("If you spend most of your time in office/school/home, give your body a little treat and go outside! Enjoy the weather and train your body! \n" +
                "\n" +
                "All you need is your body and 10 minutes if your time.");
        descriptions.add("NO GYM FULL BODY WORKOUT | TRAIN AT HOME OR THE PARK");
        descriptions.add("ONE CIRCUIT:\n" +
                "30 Seconds Skiers\n" +
                "30 Seconds Burpee to 6 Mountain Climbers\n" +
                "30 Seconds (or 2 full rounds) 90 degree rotating squats \n" +
                "Rest One Minute \n" +
                "Repeat 3 Times \n" +
                "\n" +
                "PS don't take pre-workout BEFORE cardio. I was DYING my heart was racing so much haha. Probably why this was so hard for me.");
        descriptions.add("This workout is beginner-friendly and will burn calories and strengthen your muscle. If you need a longer break - take it! That's totally okay. ♥\n" +
                "\n" +
                "Workout Focus:\n" +
                "Cardio, Muscle Toning \n" +
                "Time: 20 Min \n" +
                "Equipment: no Equipment \n" +
                "\n" +
                "If you want, you can add a resistance band.\n" +
                "\n" +
                "Workout Instructions: We start with a little warm up. Do as many reps as possible in 30 seconds. In the workout part we do as many reps as possible in 50 seconds. After 10 seconds of rest we continue to the next exercise.");
        descriptions.add("\"Here's what we gonna do today: MEDIUM INTENSE HIIT! No Equipment, you just need yourself and something to drink. We are targeting the FULL BODY with this workout.\n" +
                "\n" +
                "The Goal of this Workout is\n" +
                "- Getting the heart rate up\n" +
                "- Losing fat\n" +
                "- Gaining Muscle and Strength\n" +
                "- Increasing Endurance\n" +
                "\n" +
                "20 MINUTE MEDIUM INTENSE HIIT WORKOUT\n" +
                "- for Beginners and Advanced\n" +
                "\n" +
                "WORKOUT DETAILS\n" +
                "\n" +
                "- No Equipment\n" +
                "- Workout (20 MIN)\n" +
                "- 40 Seconds of Work, 20 Seconds of Rest\n" +
                "\n" +
                "Warm Up Stretching Exercises:\n" +
                "\n" +
                "1. Squat Hip Circle\n" +
                "2. Air Squats\n" +
                "3. Reverse Lunch Stretch\n" +
                "4. Wide Leg Stretch\n" +
                "\n" +
                "Workout:\n" +
                "\n" +
                "1. Jumping Jacks\n" +
                "2. Squat Jacks\n" +
                "3. Squat Jumps\n" +
                "4. Squat Crunch Jump\n" +
                "5. Squat Lunge Jump\n" +
                "6. Curtsy Lunges Left Leg\n" +
                "7. Curtsy Lunges Right Leg\n" +
                "8. High Knees\n" +
                "9. Half Burpees\n" +
                "10. Side to Side Half Burpees\n" +
                "11. Half Burpee High Jump\n" +
                "12. Lunge Knee Drive - Right Leg\n" +
                "13. Lunge Knee Drive - Left Leg\n" +
                "14. In Out Jumps\n" +
                "15. Half Burpee - 4 x Climbers\n" +
                "16. Fast Climbers\"");

        /*

        Full links for reference

        links.add("https://www.youtube.com/watch?v=UoC_O3HzsH0");
        links.add("https://www.youtube.com/watch?v=IeGrTqW5lek&t=28s");
        links.add("https://www.youtube.com/watch?v=iCQ2gC4DqJw");
        links.add("https://www.youtube.com/watch?v=rI_6l992GrA");
        links.add("https://www.youtube.com/watch?v=IT94xC35u6k");
        links.add("https://www.youtube.com/watch?v=bTo4NrSriWw");

        links.add("https://www.youtube.com/watch?v=ytLAobeZrbE");
        links.add("https://www.youtube.com/watch?v=E00Utc1QQqA");
        links.add("https://www.youtube.com/watch?v=0Dp2rL397jA");

        links.add("https://www.youtube.com/watch?v=ixkQaZXVQjs");
        links.add("https://www.youtube.com/watch?v=1v0yYf0PiRk");
        links.add("https://www.youtube.com/watch?v=r3h1Nf-wY6Y&ab_channel=DavidDuncan");
        links.add("https://www.youtube.com/watch?v=Im5wJLdudDg&ab_channel=JoannaSohOfficial");
        links.add("https://www.youtube.com/watch?v=sthD8ziGP1c&ab_channel=NaomiKong");
        links.add("https://www.youtube.com/watch?v=hsjwYICtWiQ&ab_channel=BrittanyLupton");

        links.add("https://www.youtube.com/watch?v=8mOrDuV1EBU&ab_channel=AshtonHallOfficial");
        links.add("https://www.youtube.com/watch?v=kUV-nqsvlGk&ab_channel=AboutWellness");
        links.add("https://www.youtube.com/watch?v=OFSRp_6koe4&ab_channel=SimeonPanda");
        links.add("https://www.youtube.com/watch?v=0ffuCBnGmQg&ab_channel=BrittanyLupton");
        links.add("https://www.youtube.com/watch?v=727Kkkwy9cQ&ab_channel=Sophia%27sLifestyle");
        links.add("https://www.youtube.com/watch?v=ioZYglRIVzA&ab_channel=growingannanas");

         */

    }

}

// Copyright 2019 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.sps;

import java.util.Collection;
import java.util.Collections;
import java.util.ArrayList;


public final class FindMeetingQuery {
  public Collection<TimeRange> query(Collection<Event> events, MeetingRequest request) {  
        
    //Assigning duration of the meeting 
     long meetingDuration = request.getDuration();


    //Saving collection of attendees 
    Collection<String> meetingAttendees = request.getAttendees();

    //Finding all incompatible time ranges
   ArrayList<TimeRange> incompatibleRanges = findIncompatibleRanges(events, meetingAttendees);

     
    //Sorting the range by chronological order 
    Collections.sort(incompatibleRanges, TimeRange.ORDER_BY_START);
    Collection<TimeRange> availableRanges = new ArrayList<TimeRange>();


    int meetingRequestStartTime = 0; 
    for (TimeRange eventRange : incompatibleRanges){
      int rangeEnd = eventRange.end();
      int rangeStart = eventRange.start();
        if (!(meetingRequestStartTime + meetingDuration > rangeStart)){ 
                      TimeRange validRange = TimeRange.fromStartEnd(meetingRequestStartTime, rangeStart, false);
          availableRanges.add(validRange);
        }
      meetingRequestStartTime = Math.max(rangeEnd,meetingRequestStartTime);       
    }


    if (meetingRequestStartTime + meetingDuration <= 24*60){
              TimeRange restOfDay = TimeRange.fromStartEnd(meetingRequestStartTime, 24*60, false);
      availableRanges.add(restOfDay);
    }

    return availableRanges;

  


  }
  private ArrayList<TimeRange> findIncompatibleRanges(Collection<Event> events, Collection<String> meetingAttendees){   
    ArrayList<TimeRange> incompatibleRanges = new ArrayList<TimeRange>();
    for (Event event : events){
      TimeRange eventRange = event.getWhen();
      //If a previously scheduled event has at least one attendee of group we're scheduling for, then the time range for
      //that meeting must be excluded, so include it in the result.
      Collection<String> eventAttendees = event.getAttendees();
      if (areMeetingAttendeesInEvent(meetingAttendees,eventAttendees)){ 
        incompatibleRanges.add(eventRange);
      }
    }

    return incompatibleRanges;
  }

 private Boolean areMeetingAttendeesInEvent(Collection<String> meetingAttendees, Collection<String> eventAttendees){
    for (String attendee : meetingAttendees) {
              if (eventAttendees.contains(attendee)){
        return true;
      }      
    }
    return false;
  }



}


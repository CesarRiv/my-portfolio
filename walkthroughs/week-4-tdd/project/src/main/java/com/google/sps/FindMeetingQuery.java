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
import java.util.ArrayList;


public final class FindMeetingQuery {
  public Collection<TimeRange> query(Collection<Event> events, MeetingRequest request) {
    throw new UnsupportedOperationException("TODO: Implement this method.");
    
    //Assigning duration of the meeting 
    long meetingduration = request.getDuration();


    //Saving collection of attendees 
    Collection<String> meetingattendees = events.getAttendees();

    //Finding all incompatible time ranges
    ArrayList<TimeRange> incompatime-ranges = FindIncompatibleRanges(events,meetingattendees)

     
    //Sorting the range by chronological order 
    Collection.sort(incompatable-ranges,TimeRange.ORDER_BY_START);





  }

  private ArrayList<TimeRange> FindIncompatibleRanges(Collection<Event> events, Collection<String> meetingattendees){
      //Returns a list of times which a meeting cannot occur
      ArrayList<TimeRange> incompatable-ranges = new Array<TimeRange>();
      for(Event event : events){
          TimeRange event-range = event.getWhen();
          Collection<String> event-attendees = event.getAttendees();
          if (areMeetingAttendeesInEvent(meetingattendees,event-attendees)){
              incompatible_ranges.add(event-range);
          }
      }
      return incompatible_ranges;
  }
}



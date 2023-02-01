
class Interval(object):
    def __init__(self, start, end):
        self.start = start
        self.end = end



def can_attend_meetings(self, intervals: List[Interval]) -> bool:
    intervals.sort(key = lambda i:i.start)

    for i in range (1,len(intervals)):
        i1 = intervals[i-1]
        i2 = intervals[i]   

        if(l1.end > i2.start):
            return false

    return true 




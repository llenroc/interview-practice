/*
看了很多地里的面经，考的题也的确是面经里出现过得。 用的是codility， 同时还全程和小姐姐开着摄像头和语音。
给的题目是yelp的 waitiing list， 主要就是让你自己写一下比较基本的waiting list 系统。
有点像简单的OOD 的题目
要求就是会有很多party进来waiting list 等有空桌子坐下来吃饭，每个party可能有的field是party的size， name， 还有等的多久时间。
然后table 可能就是有 status，比如目前这个桌子是空的还是说已经有人坐下了。
然后有空的桌子的话，你就从等最久的那个party看起，如果他们能做的下，就坐下，不然就看等的时间第二久的party看看能不能坐下，以此类推。
我用的就是自己写的party class 然后comparator写的就是直接比较他们的time。
小姐姐要求还是蛮简单的，我一开始写的很复杂就是比如同‍‍‍‌‍‍‌‌‍‌‌‌‍‍‍‌‌‍时有很多桌子空了， 该怎么安排之类的。
然后小姐姐说我们就假定只有一个空桌子，然后有三四个party在等的那种情况就好了。
*/

class Party {
    constructor(name, size, waitingTime) {
        this.name = name;
        this.size = size;
        this.waitingTime = waitingTime;
    }
}

class Table {
    constructor(isFull) {
        this.isFull = isFull;
    }

//public class Log
//        {
//            public string id;
//            public string data;
//            public Log(string inId, string inData)
//            {
//                id = inId;
//                data = inData;
//            }
//        }
//        public class LogComparer : IComparer<Log>
//        {
//            public int Compare(Log x, Log y)
//            {
//                if (x == null && y == null) return 0;
//                if (x == null) return -1;
//                if (y == null) return 1;
//                int dataCompareRes = x.data.CompareTo(y.data);
//                if (dataCompareRes == 0)
//                {
//                    return x.id.CompareTo(y.id);
//                }
//                return dataCompareRes;
//            }
//        }
//        public List<string> ReorderedLog(int size, List<string> logLines)
//        {
//            List<string> res = new List<string>();
//            if (size <= 0) return res;
//            List<string> numList = new List<string>();
//            List<Log> charList = new List<Log>();
//
//            foreach(string str in logLines)
//            {
//                int spaceIndex = str.IndexOf(" ");
//                string id = str.Substring(0, spaceIndex);
//                string data = str.Substring(spaceIndex + 1);
//                if(data.Trim()[0]>='0'&& data.Trim()[0] <= '9')
//                {
//                    numList.Add(str);
//                }
//                else
//                {
//                    charList.Add(new Log(id, data));
//                }
//            }
//            charList.Sort(new LogComparer());
//            //charList = charList.OrderBy(o => o.data).ThenBy(o => o.id).ToList();
//            foreach(Log charLog in charList)
//            {
//                res.Add(charLog.id + " " + charLog.data);
//            }
//            res.AddRange(numList);
//            return res;
//        }
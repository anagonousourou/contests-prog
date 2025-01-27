return 
(function(s)

    function shallow_copy(t)
        local t2 = {}
        for k,v in pairs(t) do
          t2[k] = v
        end
        return t2
    end

    function latest(t)
        size = 0
        for _ in pairs(t) do size = size + 1 end
        return t[size]
    end

      
    ScoresRecord = {}

    function ScoresRecord:new()                         
        newObj = {scores_values = s}                
        self.__index = self                      
        return setmetatable(newObj, self)
      end

    function ScoresRecord:scores()
        return self.scores_values
    end

    function ScoresRecord:latest()
        size = 0
        for _ in pairs(self.scores_values) do size = size + 1 end
        return self.scores_values[size]
    end

    function ScoresRecord:personal_best()
       local t = shallow_copy(self.scores_values)
       table.sort(t)
       return latest(t)
    end

    function ScoresRecord:personal_top_three()
        local t = shallow_copy(self.scores_values)
        table.sort(t, function(a,b) return a>b end)
        return {table.unpack(t, 1, 3)}
    end

    srecord = ScoresRecord:new()
    return srecord
end)

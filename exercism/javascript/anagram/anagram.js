
export const findAnagrams = (word, candidates) => {
  return candidates.filter(candidate => word.toLowerCase() !== candidate.toLowerCase() &&
    word.toLowerCase().split('').sort().toString() === candidate.toLowerCase().split('').sort().toString());
};

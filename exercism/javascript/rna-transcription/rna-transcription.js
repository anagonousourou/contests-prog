//
// This is only a SKELETON file for the 'RNA Transcription' exercise. It's been provided as a
// convenience to get you started writing code faster.
//


const DNA_TO_RNA_MAPPING = new Map(Object.entries({
  'G': 'C',
  'C': 'G',
  'T': 'A',
  'A': 'U'
}));

export const toRna = (dna) => {
  return dna.split('').map(nucleotide => DNA_TO_RNA_MAPPING.get(nucleotide)).join('');
};

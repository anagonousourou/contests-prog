class Lasagna
{
    public int ExpectedMinutesInOven()
    {
        return 40;
    }

    public int RemainingMinutesInOven(int timeElapsed)
    {
        return ExpectedMinutesInOven() - timeElapsed;
    }

    public int PreparationTimeInMinutes(int nbLayers)
    {
        return nbLayers * 2;
    }

    public int ElapsedTimeInMinutes(int nbLayers, int timeSpentInOven)
    {
        return PreparationTimeInMinutes(nbLayers) + timeSpentInOven;
    }
}

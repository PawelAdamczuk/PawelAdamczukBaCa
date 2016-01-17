#Pawel Adamczuk
#Parser of a database in an XML-like format, including sample e-mail generation.

#!/usr/bin/perl

use 5.010;
use strict;
use warnings;
#use open qw< :encoding(UTF-8) >;
#use Data::Dumper qw(Dumper);

#my $filename = 'test2.in';
#my $filehandler;
my $key = "klucz";
my $separator = ":";
my @labels;
my $colCount;
my $keyCol = 0;
my %data;
my @row;

#open ($filehandler, "<", $filename) or die "Could not open file $filename !";#local $/ = undef;
#my $file = <$filehandler>;

while (my $line = <STDIN>) {
  if ( $line =~  m/<dane>/ ) #reading data into the hash table
  {
    $line = <STDIN>;
    
    if ( $line =~ /<klucz\s*wartosc\s*=\s*"(.*)"\s*\/>/ ) #key defined
    {
      $key = $1;
      $line = <STDIN>;
    }          if ( $line =~ m/<plik separator="(.*)">/ ) #reading the separator
    {
      $separator = $1;
      $line = <STDIN>;
    }
        @labels = split( $separator, $line ); #splitting the labels
    foreach my $var (@labels)
    {
      $var =~ s/^\s+|\s+$//g; #trim
    }
    $colCount = $#labels + 1; #number of columns
    
        for (my $i = 0; $i < $colCount; ++$i) #finding the column index of the key
    {
      if ($labels[$i] eq $key)
      {
        $keyCol = $i;
      }
    }    
    $line = <STDIN>; #reading the first data row
    
    while ( $line !~ m/<\/plik>/ and defined $line) #reading the data rows
    {
      @row = split( $separator, $line ); #row of values
      foreach my $var (@row)
      {
        $var =~ s/^\s+|\s+$//g; #trim
      }
      
            for (my $i = 0; $i < $colCount; ++$i) #saving the values in the row to the hash
      {
        $data {$row[$keyCol]} {$labels[$i]} = $row[$i];
      }
      $line = <STDIN>;
    }
  }
  
    elsif ( $line =~ /<polecenia>/ )
  {
    while ( $line !~ m/<\/polecenia>/ and defined $line ) #reading the action rows
    {
      if ( $line =~ m/<lista/ ) #lista
      {
        my $outSep;
        my @fields;
        if ( $line =~ m/pola="(.*?)"/ )
        {
          @fields = split (",", $1);
        }
        if ( $line =~ m/separator="(.*?)"/ )
        {
          $outSep = $1;
        }
        else
        {
          $outSep = ',';
        }
        
        $, = $outSep;
        print @fields and print "\n";
        
        foreach my $var (sort {$b cmp $a} keys %data) #for each record in the main table
        {
          my @tempArr;
          foreach my $var2 (@fields)
          {
            push @tempArr, $data {$var} {$var2};
          }
          print @tempArr and print "\n";
        }
        print "---\n";
        
      }
      elsif ( $line =~ m/<selektor/ ) #selektor
      {
        my $field;
        if ( $line =~ m/pole="(.*?)"/ )
        {
          $field = $1;
        }
        my $regex;
        if ( $line =~ m/klucz="(.*?)"/ )
        {
          $regex = $1;
        }
        my $new = undef;
        if ( $line =~ m/nowa="(.*?)"/ )
        {
          $new = $1;
        }
                if (defined $new and defined $regex and defined $field)
        {
          foreach my $var (keys %data)
          {
            if ($data{$var}{$field} =~ m/$regex/)
            {
              $data {$var}{$field} = $new;
            }
          }
        }
        elsif (defined $regex and defined $field)
        {
          foreach my $var (keys %data)
          {
            if ($data {$var}{$field} =~ m/$regex/)
            {
             delete $data {$var};
            }
          }
        }
        
      }
      elsif ( $line =~ m/<mail>/ ) #mail
      {
        $line = <STDIN>;
        my $mail;
        while ( $line !~ m/<\/mail/ and defined $line)
        {
          $mail .= $line;
          $line = <STDIN>;
        }
        foreach my $var (sort {$b cmp $a} keys %data) #for each record in the main table
        {
          my $tempmail = $mail;
          $tempmail =~ s/\[(.*?)\]/$data{$var}{$1}/g;
          print $tempmail and print "---\n";
        }
      }
      $line = <STDIN>;

    }
    
  }
}

#print Dumper \%data;


my @arr; 
